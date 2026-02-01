// File Name: circular_singly_linked_list_create_node.c
// Program to create a node in a circular singly linked list

#include <stdio.h>
#include <stdlib.h>

// Definition of node
struct node {
    int data;
    struct node *next;
};

// Function to create a new node
struct node* create_node(int value) {
    struct node *newnode = (struct node *)malloc(sizeof(struct node));
    if (newnode == NULL) {
        printf("Memory allocation failed\n");
        return NULL;
    }
    newnode->data = value;
    newnode->next = newnode;   // Circular link
    return newnode;
}

int main() {
    struct node *head = create_node(10);
    return 0;
}
