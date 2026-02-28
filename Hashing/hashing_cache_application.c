/* File Name: hashing_cache_application.c */

#include <stdio.h>
#include <stdlib.h>

#define SIZE 10
#define EMPTY -1

struct Cache {
    int key;
    long long value;
};

struct Cache cache[SIZE];

// Hash Function
int hashFunction(int key) {
    return key % SIZE;
}

// Factorial (Expensive Operation)
long long factorial(int n) {
    long long result = 1;
    for(int i = 1; i <= n; i++)
        result *= i;
    return result;
}

// Get value using cache
long long getFactorial(int n) {
    int index = hashFunction(n);
    int start = index;

    while (cache[index].key != EMPTY) {
        if (cache[index].key == n) {
            printf("Cache HIT for %d\n", n);
            return cache[index].value;
        }
        index = (index + 1) % SIZE;
        if (index == start)
            break;
    }

    printf("Cache MISS for %d. Computing...\n", n);
    long long result = factorial(n);

    cache[index].key = n;
    cache[index].value = result;

    return result;
}

// Initialize
void initialize() {
    for (int i = 0; i < SIZE; i++)
        cache[i].key = EMPTY;
}

int main() {
    initialize();
    int n, choice;

    while(1) {
        printf("\n1.Compute Factorial\n2.Exit\n");
        scanf("%d", &choice);

        if(choice == 1) {
            printf("Enter number: ");
            scanf("%d", &n);
            printf("Result = %lld\n", getFactorial(n));
        }
        else
            break;
    }

    return 0;
}
