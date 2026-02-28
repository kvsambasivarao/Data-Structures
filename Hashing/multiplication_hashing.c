/* File Name: multiplication_hashing.c */

#include <stdio.h>
#include <math.h>

#define TABLE_SIZE 10
#define A 0.618033

int hashFunction(int key) {
    double fractional = fmod(key * A, 1);
    return (int)(TABLE_SIZE * fractional);
}

int main() {
    int keys[] = {23, 45, 12, 67, 34};
    int n = sizeof(keys) / sizeof(keys[0]);

    printf("Multiplication Method Hashing\n");
    printf("Table Size = %d\n\n", TABLE_SIZE);

    for(int i = 0; i < n; i++) {
        int index = hashFunction(keys[i]);
        printf("Key: %d -> Hash Index: %d\n", keys[i], index);
    }

    return 0;
}
