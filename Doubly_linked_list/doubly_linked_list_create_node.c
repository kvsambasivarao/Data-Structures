// File Name: doubly_linked_list_create_node.c
// Program to create a node in a doubly linked list

#include <stdio.h>
#include <stdlib.h>

// Definition of node
struct node {
    int data;
    struct node *prev;
    struct node *next;
};

// Function to create a new node
struct node* create_node(int value) {
    struct node *newnode = (struct node*)malloc(sizeof(struct node));
    if (newnode == NULL) {
        printf("Memory allocation failed\n");
        return NULL;
    }
    newnode->data = value;
    newnode->prev = NULL;
    newnode->next = NULL;
    return newnode;
}

int main() {
    struct node *node1 = create_node(10);
    return 0;
}
