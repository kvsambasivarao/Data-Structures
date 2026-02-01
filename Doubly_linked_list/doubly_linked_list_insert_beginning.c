// File Name: doubly_linked_list_insert_beginning.c
// Program to insert a node at the beginning of a doubly linked list

#include <stdio.h>
#include <stdlib.h>

// Definition of node
struct node {
    int data;
    struct node *prev;
    struct node *next;
};

struct node *head = NULL;

// Function to insert at beginning
void insert_beg(int value) {
    struct node *newnode = (struct node *)malloc(sizeof(struct node));

    newnode->data = value;
    newnode->prev = NULL;
    newnode->next = head;

    if (head != NULL)
        head->prev = newnode;

    head = newnode;
}

int main() {
    insert_beg(10);
    return 0;
}
