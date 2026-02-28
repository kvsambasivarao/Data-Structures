/* File Name: radix_conversion_hashing.c */

#include <stdio.h>
#include <math.h>

#define TABLE_SIZE 10
#define BASE 13

long convertToDecimal(long key) {
    long decimal = 0;
    int power = 0;

    while (key > 0) {
        int digit = key % 10;
        decimal += digit * pow(BASE, power);
        key = key / 10;
        power++;
    }

    return decimal;
}

int hashFunction(long key) {
    long decimalValue = convertToDecimal(key);
    return decimalValue % TABLE_SIZE;
}

int main() {
    long keys[] = {210485, 12345, 45678};
    int n = sizeof(keys) / sizeof(keys[0]);

    printf("Radix Conversion Method Hashing\n");
    printf("Table Size = %d\n\n", TABLE_SIZE);

    for(int i = 0; i < n; i++) {
        int index = hashFunction(keys[i]);
        printf("Key (base %d): %ld -> Hash Index: %d\n",
               BASE, keys[i], index);
    }

    return 0;
}
