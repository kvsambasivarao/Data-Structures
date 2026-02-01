// File Name: doubly_linked_list_create_n_nodes.c
// Program to create a doubly linked list with n nodes

#include <stdio.h>
#include <stdlib.h>

// Definition of node
struct node {
    int data;
    struct node *prev;
    struct node *next;
};

struct node *head = NULL;

// Function to create doubly linked list with n nodes
void create_list(int n) {
    struct node *newnode, *temp;
    int i, value;

    for (i = 1; i <= n; i++) {
        printf("Enter data for node %d: ", i);
        scanf("%d", &value);

        newnode = (struct node *)malloc(sizeof(struct node));
        newnode->data = value;
        newnode->prev = NULL;
        newnode->next = NULL;

        if (head == NULL) {
            head = newnode;
            temp = head;
        } else {
            temp->next = newnode;
            newnode->prev = temp;
            temp = newnode;
        }
    }
}

int main() {
    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);

    create_list(n);
    return 0;
}
