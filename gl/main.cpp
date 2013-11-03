#include <GL/freeglut.h>
#include <iostream>
#include <cmath>

#define MIN -25.0
#define MAX  25.0
#define DELTA 0.5
#define DELTA_THETA 1.0

int oldX = -1;
int oldY = -1;

GLfloat pitch = -70.0;
GLfloat yaw   =   0.0;
GLfloat roll  =  30.0;

GLfloat lerp(GLfloat x,
             GLfloat xMin, GLfloat xMax,
             GLfloat yMin, GLfloat yMax) {
  return x * (yMax - yMin) / (xMax - xMin);
}

GLfloat func(GLfloat x, GLfloat y) {
  GLfloat radical = std::sqrt(x * x + y * y);
  return 4 * std::sin(radical) / radical;
}

void display() {
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
  glRotated(pitch, 1.0, 0.0, 0.0);
  glRotated(yaw  , 0.0, 0.0, 1.0);
  glRotated(roll , 0.0, 0.0, 1.0);

  glClear(GL_COLOR_BUFFER_BIT);

  glColor3f(1.0, 1.0, 1.0);

  for (GLfloat x = MIN; x < MAX; x += DELTA) {
    glBegin(GL_LINE_STRIP);
    for (GLfloat y = MIN; y < MAX; y += DELTA) {
      GLfloat z = func(x, y);
      glVertex3f(x, y, z);
    }
    glEnd();
  }

  for (GLfloat y = MIN; y < MAX; y += DELTA) {
    glBegin(GL_LINE_STRIP);
    for (GLfloat x = MIN; x < MAX; x += DELTA) {
      GLfloat z = func(x, y);
      glVertex3f(x, y, z);
    }
    glEnd();
  }

  glutSwapBuffers();
}

void init() {
  glClearColor(0.0, 0.0, 0.0, 0.0);
  glShadeModel(GL_FLAT);
}

void reshape(int w, int h) {
  glViewport (0, 0, (GLsizei) w, (GLsizei) h);
  glMatrixMode (GL_PROJECTION);
  glLoadIdentity();

  if (w <= h) {
    glOrtho(MIN, MAX,
            lerp(MIN, 0, w, 0, h), lerp(MAX, 0, w, 0, h),
            2*MIN, 2*MAX);
  } else {
    glOrtho(lerp(MIN, 0, h, 0, w), lerp(MAX, 0, h, 0, w),
            MIN, MAX,
            2*MIN, 2*MAX);
  }

  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
  glRotated(pitch, 1.0, 0.0, 0.0);
  glRotated(yaw  , 0.0, 0.0, 1.0);
  glRotated(roll , 0.0, 0.0, 1.0);
}

void mouse(int button, int state, int x, int y) {
  switch(button) {
    case GLUT_LEFT_BUTTON:
      oldX = x;
      oldY = y;
      break;

    default:
      break;
  }
}

void motion(int x, int y) {
  if (x - oldX < 0) {
    yaw -= DELTA_THETA;
  } else if (x - oldX > 0) {
    yaw += DELTA_THETA;
  }

  if (y - oldY < 0) {
    pitch -= DELTA_THETA;
  } else if (y - oldY > 0) {
    pitch += DELTA_THETA;
  }

  oldX = x;
  oldY = y;

  glutPostRedisplay();
}

int main(int argc, char** argv) {
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
  glutInitWindowSize(800, 800);
  glutInitWindowPosition(100, 100);
  glutCreateWindow("Surface3D");
  init();
  glutDisplayFunc(display);
  glutReshapeFunc(reshape);
  glutMouseFunc(mouse);
  glutMotionFunc(motion);
  glutMainLoop();

  return 0;
}
