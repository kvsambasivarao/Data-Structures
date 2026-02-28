/* File Name: hash_table_quadratic_probing.c */

#include <stdio.h>
#include <stdlib.h>

#define SIZE 10
#define EMPTY -1
#define DELETED -2

int hashTable[SIZE];

// Initialize
void initialize() {
    for (int i = 0; i < SIZE; i++)
        hashTable[i] = EMPTY;
}

// Hash Function
int hashFunction(int key) {
    return key % SIZE;
}

// Insert
void insert(int key) {
    int index = hashFunction(key);
    int i = 0;
    int newIndex;

    while (i < SIZE) {
        newIndex = (index + i * i) % SIZE;

        if (hashTable[newIndex] == EMPTY || hashTable[newIndex] == DELETED) {
            hashTable[newIndex] = key;
            printf("Key %d inserted at index %d\n", key, newIndex);
            return;
        }
        i++;
    }
    printf("Hash Table is Full\n");
}

// Search
void search(int key) {
    int index = hashFunction(key);
    int i = 0;
    int newIndex;

    while (i < SIZE) {
        newIndex = (index + i * i) % SIZE;

        if (hashTable[newIndex] == EMPTY)
            break;

        if (hashTable[newIndex] == key) {
            printf("Key %d found at index %d\n", key, newIndex);
            return;
        }
        i++;
    }
    printf("Key %d not found\n", key);
}

// Delete
void deleteKey(int key) {
    int index = hashFunction(key);
    int i = 0;
    int newIndex;

    while (i < SIZE) {
        newIndex = (index + i * i) % SIZE;

        if (hashTable[newIndex] == EMPTY)
            break;

        if (hashTable[newIndex] == key) {
            hashTable[newIndex] = DELETED;
            printf("Key %d deleted\n", key);
            return;
        }
        i++;
    }
    printf("Key %d not found\n", key);
}

// Display
void display() {
    printf("\nHash Table:\n");
    for (int i = 0; i < SIZE; i++) {
        if (hashTable[i] == EMPTY)
            printf("Index %d -> EMPTY\n", i);
        else if (hashTable[i] == DELETED)
            printf("Index %d -> DELETED\n", i);
        else
            printf("Index %d -> %d\n", i, hashTable[i]);
    }
}

// Main
int main() {
    int choice, key;
    initialize();

    while (1) {
        printf("\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Exit\n");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter key: ");
                scanf("%d", &key);
                insert(key);
                break;
            case 2:
                printf("Enter key: ");
                scanf("%d", &key);
                search(key);
                break;
            case 3:
                printf("Enter key: ");
                scanf("%d", &key);
                deleteKey(key);
                break;
            case 4:
                display();
                break;
            case 5:
                exit(0);
        }
    }
}
