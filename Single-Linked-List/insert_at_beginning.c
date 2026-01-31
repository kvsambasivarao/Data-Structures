#include <stdio.h>
#include <stdlib.h>

// Definition of Node
struct Node {
    int data;
    struct Node *next;
};

// Function to insert a node at the beginning
struct Node* insert_beg(struct Node *head) {
    struct Node *newNode;

    newNode = (struct Node*)malloc(sizeof(struct Node));

    if (newNode == NULL) {
        printf("Memory allocation failed\n");
        return head;
    }

    printf("Enter data for new node: ");
    scanf("%d", &newNode->data);

    newNode->next = head;   // Link new node to existing list
    head = newNode;        // Update head

    return head;
}
