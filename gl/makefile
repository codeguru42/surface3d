LDLIBS = -lGL -lglut -lGLU
OBJ = main.o
EXE = surface3d

${EXE}: ${OBJ}
	g++ ${OBJ} ${LDLIBS} -o ${EXE}

clean:
	rm *~ *.o ${EXE}
