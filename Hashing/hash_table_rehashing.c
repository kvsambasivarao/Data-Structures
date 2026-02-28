/* File Name: hash_table_rehashing.c */

#include <stdio.h>
#include <stdlib.h>

#define INITIAL_SIZE 5
#define LOAD_FACTOR 0.7
#define EMPTY -1

int *hashTable;
int size = INITIAL_SIZE;
int count = 0;

// Hash Function
int hashFunction(int key) {
    return key % size;
}

// Rehash Function
void rehash() {
    int oldSize = size;
    int *oldTable = hashTable;

    size = size * 2;
    hashTable = (int *)malloc(size * sizeof(int));

    for (int i = 0; i < size; i++)
        hashTable[i] = EMPTY;

    count = 0;

    for (int i = 0; i < oldSize; i++) {
        if (oldTable[i] != EMPTY) {
            int key = oldTable[i];
            int index = hashFunction(key);

            while (hashTable[index] != EMPTY)
                index = (index + 1) % size;

            hashTable[index] = key;
            count++;
        }
    }

    free(oldTable);
    printf("Rehashing done. New size = %d\n", size);
}

// Insert
void insert(int key) {
    float load = (float)count / size;

    if (load > LOAD_FACTOR)
        rehash();

    int index = hashFunction(key);

    while (hashTable[index] != EMPTY)
        index = (index + 1) % size;

    hashTable[index] = key;
    count++;
    printf("Key %d inserted\n", key);
}

// Display
void display() {
    printf("\nHash Table:\n");
    for (int i = 0; i < size; i++) {
        if (hashTable[i] == EMPTY)
            printf("Index %d -> EMPTY\n", i);
        else
            printf("Index %d -> %d\n", i, hashTable[i]);
    }
}

// Main
int main() {
    hashTable = (int *)malloc(size * sizeof(int));
    for (int i = 0; i < size; i++)
        hashTable[i] = EMPTY;

    int choice, key;

    while (1) {
        printf("\n1.Insert\n2.Display\n3.Exit\n");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter key: ");
                scanf("%d", &key);
                insert(key);
                break;
            case 2:
                display();
                break;
            case 3:
                exit(0);
        }
    }
}
