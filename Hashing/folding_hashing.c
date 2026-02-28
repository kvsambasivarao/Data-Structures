/* File Name: folding_hashing.c */

#include <stdio.h>

#define TABLE_SIZE 10

int hashFunction(long key) {
    int sum = 0;

    while (key > 0) {
        sum += key % 100;   // taking 2-digit parts
        key = key / 100;
    }

    return sum % TABLE_SIZE;
}

int main() {
    long keys[] = {12345678, 98765432, 45678912};
    int n = sizeof(keys) / sizeof(keys[0]);

    printf("Folding Method Hashing\n");
    printf("Table Size = %d\n\n", TABLE_SIZE);

    for(int i = 0; i < n; i++) {
        int index = hashFunction(keys[i]);
        printf("Key: %ld -> Hash Index: %d\n", keys[i], index);
    }

    return 0;
}
