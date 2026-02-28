/* File Name: universal_hashing.c */

#include <stdio.h>

#define TABLE_SIZE 10
#define P 101   // prime number greater than max key

int a = 7;      // random constant (1 ≤ a ≤ p-1)
int b = 3;      // random constant (0 ≤ b ≤ p-1)

int hashFunction(int key) {
    return ((a * key + b) % P) % TABLE_SIZE;
}

int main() {
    int keys[] = {23, 45, 12, 67, 34};
    int n = sizeof(keys) / sizeof(keys[0]);

    printf("Universal Hashing Method\n");
    printf("Table Size = %d\n\n", TABLE_SIZE);

    for(int i = 0; i < n; i++) {
        int index = hashFunction(keys[i]);
        printf("Key: %d -> Hash Index: %d\n", keys[i], index);
    }

    return 0;
}
