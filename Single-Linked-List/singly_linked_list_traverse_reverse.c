// File Name: singly_linked_list_traverse_reverse.c
// Program to traverse and display a singly linked list in reverse order

#include <stdio.h>
#include <stdlib.h>

// Definition of node
struct node {
    int data;
    struct node *next;
};

struct node *head = NULL;

// Recursive function to traverse in reverse
void traverse_reverse(struct node *temp) {
    if (temp == NULL)
        return;

    traverse_reverse(temp->next);
    printf("%d -> ", temp->data);
}

int main() {
    if (head == NULL) {
        printf("List is empty.\n");
    } else {
        printf("Reverse order: ");
        traverse_reverse(head);
        printf("NULL\n");
    }
    return 0;
}
