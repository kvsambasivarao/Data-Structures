// File Name: delete_pos.c
// Program to delete a node at a given position in a singly linked list

#include <stdio.h>
#include <stdlib.h>

// Definition of node
struct node {
    int data;
    struct node *next;
};

struct node *head = NULL;

// Function to delete node at given position
void delete_pos(int pos) {
    struct node *temp, *prev;
    int i;

    if (head == NULL) {
        printf("List is empty. Deletion not possible.\n");
        return;
    }

    // If position is 1 (beginning)
    if (pos == 1) {
        temp = head;
        head = head->next;
        free(temp);
        printf("Node at position %d deleted successfully.\n", pos);
        return;
    }

    temp = head;
    for (i = 1; i < pos; i++) {
        prev = temp;
        temp = temp->next;

        if (temp == NULL) {
            printf("Invalid position.\n");
            return;
        }
    }

    prev->next = temp->next;
    free(temp);
    printf("Node at position %d deleted successfully.\n", pos);
}

int main() {
    delete_pos(3);   // example position
    return 0;
}
