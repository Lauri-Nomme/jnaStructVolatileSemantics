#include <stdio.h>
#include <stdlib.h>

typedef struct S {
	int i1;
	long l1;
	int i2;
	long l2;
} S;

void dump(const S* s) {
	printf("dumping %p\n", s);
	printf("%d %ld %d %ld\n", s->i1, s->l1, s->i2, s->l2);
	for (size_t i = 0; i < sizeof(S); ++i) {
		printf("%02X ", ((unsigned char*)s)[i]);
	}
	printf("\n");
}

void * createS() {
    return malloc(sizeof(S));
}
