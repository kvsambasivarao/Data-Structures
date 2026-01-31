#include <stdio.h>
#include <stdlib.h>

// Definition of node
struct Node {
    int data;
    struct Node *next;
};

// Function to create a new node
struct Node* createNode() {
    struct Node *newNode;

    // Allocate memory
    newNode = (struct Node*)malloc(sizeof(struct Node));

    if (newNode == NULL) {
        printf("Memory allocation failed\n");
        return NULL;
    }

    // Read data
    printf("Enter data for the node: ");
    scanf("%d", &newNode->data);

    // Initialize next pointer
    newNode->next = NULL;

    return newNode;
}
