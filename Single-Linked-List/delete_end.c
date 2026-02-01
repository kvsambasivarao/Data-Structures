// File Name: delete_end.c
// Program to delete the last node of a singly linked list

#include <stdio.h>
#include <stdlib.h>

// Definition of node
struct node {
    int data;
    struct node *next;
};

struct node *head = NULL;

// Function to delete the last node
void delete_end() {
    struct node *temp, *prev;

    if (head == NULL) {
        printf("List is empty. Deletion not possible.\n");
        return;
    }

    // If only one node exists
    if (head->next == NULL) {
        free(head);
        head = NULL;
        printf("Last node deleted successfully.\n");
        return;
    }

    temp = head;
    while (temp->next != NULL) {
        prev = temp;
        temp = temp->next;
    }
    prev->next = NULL;
    free(temp);
    printf("Last node deleted successfully.\n");
}

int main() {
    delete_end();
    return 0;
}
