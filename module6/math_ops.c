#include <stdio.h>

void print_math(int, int);

int main() {

    int a, b;

    printf("Please enter the first number? ");
    scanf("%d", &a);

    printf("Please enter the second number? ");
    scanf("%d", &b);

    printf("You entered %d and %d.\n", a, b);

    print_math(a,b);

    return 0;

}

void print_math(int a, int b) {

    printf("Sum: ");
    printf("%d\n", a + b);

    printf("Product: ");
    printf("%d\n", a * b);





}