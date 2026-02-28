/* File Name: digit_extraction_hashing.c */

#include <stdio.h>

#define TABLE_SIZE 10

int hashFunction(long key) {
    int digit2 = (key / 10) % 10;       // 2nd digit from right
    int digit4 = (key / 1000) % 10;     // 4th digit from right
    int digit6 = (key / 100000) % 10;   // 6th digit from right

    int extracted = digit2 * 100 + digit4 * 10 + digit6;

    return extracted % TABLE_SIZE;
}

int main() {
    long keys[] = {987654321, 123456789, 456789123};
    int n = sizeof(keys) / sizeof(keys[0]);

    printf("Digit Extraction Method Hashing\n");
    printf("Table Size = %d\n\n", TABLE_SIZE);

    for(int i = 0; i < n; i++) {
        int index = hashFunction(keys[i]);
        printf("Key: %ld -> Hash Index: %d\n", keys[i], index);
    }

    return 0;
}
