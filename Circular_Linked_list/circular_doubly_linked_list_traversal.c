// File Name: circular_doubly_linked_list_traversal.c
// Program to traverse a circular doubly linked list
// forward and backward

#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *prev;
    struct node *next;
};

struct node *head = NULL;

// Forward traversal
void traverse_forward() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct node *temp = head;
    printf("Forward traversal: ");
    do {
        printf("%d <-> ", temp->data);
        temp = temp->next;
    } while (temp != head);
    printf("HEAD\n");
}

// Backward traversal
void traverse_backward() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct node *temp = head->prev;  // start from last node
    printf("Backward traversal: ");
    do {
        printf("%d <-> ", temp->data);
        temp = temp->prev;
    } while (temp != head->prev);
    printf("HEAD\n");
}

int main() {
    traverse_forward();
    traverse_backward();
    return 0;
}
