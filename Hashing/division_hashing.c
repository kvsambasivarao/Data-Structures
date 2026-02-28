/* File Name: division_hashing.c */

#include <stdio.h>

#define TABLE_SIZE 10

int hashFunction(int key) {
    return key % TABLE_SIZE;
}

int main() {
    int keys[] = {23, 45, 12, 67, 34};
    int n = sizeof(keys) / sizeof(keys[0]);

    printf("Division Method Hashing\n");
    printf("Table Size = %d\n\n", TABLE_SIZE);

    for(int i = 0; i < n; i++) {
        int index = hashFunction(keys[i]);
        printf("Key: %d -> Hash Index: %d\n", keys[i], index);
    }

    return 0;
}
