/* File Name: hash_table_separate_chaining.c */

#include <stdio.h>
#include <stdlib.h>

#define SIZE 10

// Node structure for linked list
struct Node {
    int key;
    struct Node* next;
};

// Hash table array
struct Node* hashTable[SIZE];

// Hash Function (Division Method)
int hashFunction(int key) {
    return key % SIZE;
}

// Insert Operation
void insert(int key) {
    int index = hashFunction(key);

    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->key = key;
    newNode->next = hashTable[index];
    hashTable[index] = newNode;

    printf("Key %d inserted at index %d\n", key, index);
}

// Search Operation
void search(int key) {
    int index = hashFunction(key);
    struct Node* temp = hashTable[index];

    while (temp != NULL) {
        if (temp->key == key) {
            printf("Key %d found at index %d\n", key, index);
            return;
        }
        temp = temp->next;
    }
    printf("Key %d not found\n", key);
}

// Delete Operation
void deleteKey(int key) {
    int index = hashFunction(key);
    struct Node* temp = hashTable[index];
    struct Node* prev = NULL;

    while (temp != NULL) {
        if (temp->key == key) {
            if (prev == NULL)
                hashTable[index] = temp->next;
            else
                prev->next = temp->next;

            free(temp);
            printf("Key %d deleted from index %d\n", key, index);
            return;
        }
        prev = temp;
        temp = temp->next;
    }
    printf("Key %d not found\n", key);
}

// Display Hash Table
void display() {
    printf("\nHash Table:\n");
    for (int i = 0; i < SIZE; i++) {
        struct Node* temp = hashTable[i];
        printf("Index %d -> ", i);
        while (temp != NULL) {
            printf("%d -> ", temp->key);
            temp = temp->next;
        }
        printf("NULL\n");
    }
}

// Main Function
int main() {
    int choice, key;

    while (1) {
        printf("\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter key to insert: ");
                scanf("%d", &key);
                insert(key);
                break;

            case 2:
                printf("Enter key to search: ");
                scanf("%d", &key);
                search(key);
                break;

            case 3:
                printf("Enter key to delete: ");
                scanf("%d", &key);
                deleteKey(key);
                break;

            case 4:
                display();
                break;

            case 5:
                exit(0);

            default:
                printf("Invalid choice\n");
        }
    }
    return 0;
}
