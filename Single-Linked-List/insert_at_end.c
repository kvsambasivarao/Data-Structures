/* File Name: insert_at_end.c */

#include <stdio.h>
#include <stdlib.h>

// Definition of Node
struct Node {
    int data;
    struct Node *next;
};

// Function to insert a node at the end
struct Node* insert_end(struct Node *head) {
    struct Node *newNode, *temp;

    newNode = (struct Node*)malloc(sizeof(struct Node));

    if (newNode == NULL) {
        printf("Memory allocation failed\n");
        return head;
    }

    printf("Enter data for new node: ");
    scanf("%d", &newNode->data);
    newNode->next = NULL;

    // If list is empty
    if (head == NULL) {
        head = newNode;
    } else {
        temp = head;
        while (temp->next != NULL)
            temp = temp->next;
        temp->next = newNode;
    }

    return head;
}
