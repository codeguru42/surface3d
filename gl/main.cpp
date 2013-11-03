#include <GL/freeglut.h>
#include <cmath>

#define MIN -25.0
#define MAX  25.0
#define DELTA 0.5

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

  glFlush();
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
  glRotated(-70.0, 1.0, 0.0, 0.0);
  glRotated( 30.0, 0.0, 0.0, 1.0);
}

int main(int argc, char** argv) {
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
  glutInitWindowSize(800, 800);
  glutInitWindowPosition(100, 100);
  glutCreateWindow("hello");
  init();
  glutDisplayFunc(display);
  glutReshapeFunc(reshape);
  glutMainLoop();

  return 0;
}
