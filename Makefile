all: dbgmalloc.so target/jnaStructVolatileSemantics-1.0-SNAPSHOT.jar

src/main/resources/linux-x86-64/liblib.so: lib.c
	gcc -Wall -Werror -fpic -shared -o src/main/resources/linux-x86-64/liblib.so lib.c

dbgmalloc.so: dbgmalloc.c
	gcc -Wall -Werror -fpic -shared -o dbgmalloc.so dbgmalloc.c

target/jnaStructVolatileSemantics-1.0-SNAPSHOT.jar: src/main/resources/linux-x86-64/liblib.so
	mvn package

test: dbgmalloc.so target/jnaStructVolatileSemantics-1.0-SNAPSHOT.jar
	LD_PRELOAD=$(realpath dbgmalloc.so) java -jar target/jnaStructVolatileSemantics-1.0-SNAPSHOT.jar
