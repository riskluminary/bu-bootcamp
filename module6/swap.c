#include <stdio.h>

void swap(int*, int*);
void broken_swap(int, int);


int main() {

    int a = 3, b = 7;

    printf("Testing correct swap.\n");
    printf("a: %d; b: %d\n", a, b);

    printf("Swapping a and b.\n");
    swap(&a, &b);

    printf("a: %d; b: %d\n", a, b);

    a = 3, b= 7;

    printf("\n\nTesting broken swap.\n");
    printf("a: %d; b: %d\n", a, b);

    printf("Swapping a and b.\n");
    broken_swap(a, b);

    printf("a: %d; b: %d\n", a, b);


    return 0;

}

void swap(int* first, int* second) {

    int tmp = *first;

    *first = *second;
    *second = tmp;

}

/* this function will not work because it does not use pointers*/
void broken_swap(int first, int second) {

    int tmp = first;

    first = second;
    second = tmp;

}
