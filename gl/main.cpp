#include <GL/freeglut.h>

#define MIN -1.0
#define MAX  1.0

void display() {
  glClear(GL_COLOR_BUFFER_BIT);

  glColor3f(1.0, 1.0, 1.0);
  glBegin(GL_POLYGON); {
    glVertex3f( 0.5,  0.5, 0.0);
    glVertex3f(-0.5,  0.5, 0.0);
    glVertex3f(-0.5, -0.5, 0.0);
    glVertex3f( 0.5, -0.5, 0.0);
  } glEnd();

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
  if (w <= h)
    glOrtho (MIN, MAX, MIN*(GLfloat)h/(GLfloat)w,
      MAX*(GLfloat)h/(GLfloat)w, -10.0, 10.0);
  else
    glOrtho (MIN*(GLfloat)w/(GLfloat)h,
      MAX*(GLfloat)w/(GLfloat)h, MIN, MAX, -10.0, 10.0);
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
}

int main(int argc, char** argv) {
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
  glutInitWindowSize(250, 250);
  glutInitWindowPosition(100, 100);
  glutCreateWindow("hello");
  init();
  glutDisplayFunc(display);
  glutReshapeFunc(reshape);
  glutMainLoop();

  return 0;
}
