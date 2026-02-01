// File Name: doubly_linked_list_insert_end.c
// Program to insert a node at the end of a doubly linked list

#include <stdio.h>
#include <stdlib.h>

// Definition of node
struct node {
    int data;
    struct node *prev;
    struct node *next;
};

struct node *head = NULL;

// Function to insert at end
void insert_end(int value) {
    struct node *newnode, *temp;

    newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = value;
    newnode->prev = NULL;
    newnode->next = NULL;

    // If list is empty
    if (head == NULL) {
        head = newnode;
        return;
    }

    temp = head;
    while (temp->next != NULL)
        temp = temp->next;

    temp->next = newnode;
    newnode->prev = temp;
}

int main() {
    insert_end(10);
    return 0;
}
