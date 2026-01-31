/* File Name: insert_at_position.c */

#include <stdio.h>
#include <stdlib.h>

// Definition of Node
struct Node {
    int data;
    struct Node *next;
};

// Function to insert node at a given position
struct Node* insert_pos(struct Node *head, int pos) {
    struct Node *newNode, *temp;
    int i;

    newNode = (struct Node*)malloc(sizeof(struct Node));

    if (newNode == NULL) {
        printf("Memory allocation failed\n");
        return head;
    }

    printf("Enter data for new node: ");
    scanf("%d", &newNode->data);

    // Insert at beginning if position is 1
    if (pos == 1) {
        newNode->next = head;
        head = newNode;
        return head;
    }

    temp = head;
    for (i = 1; i < pos - 1 && temp != NULL; i++) {
        temp = temp->next;
    }

    if (te
