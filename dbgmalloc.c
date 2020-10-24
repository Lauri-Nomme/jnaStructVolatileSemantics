#define _GNU_SOURCE
#include <dlfcn.h>

static void* (*real_malloc)(size_t size);


void *malloc(size_t size) {
	if (real_malloc == 0) {
		real_malloc = dlsym(RTLD_NEXT, "malloc");
	}

	void *res = real_malloc(size);

	for (size_t i = 0; i < size; ++i) {
		((char*)res)[i] = 0xCC;
	}

	return res;
}
