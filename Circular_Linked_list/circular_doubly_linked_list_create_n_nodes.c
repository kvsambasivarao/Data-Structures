// File Name: circular_doubly_linked_list_create_n_nodes.c
// Program to create a circular doubly linked list with n nodes

#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *prev;
    struct node *next;
};

struct node *head = NULL;

// Function to create circular doubly linked list with n nodes
void create_list(int n) {
    struct node *newnode, *temp;
    int value, i;

    for (i = 1; i <= n; i++) {
        printf("Enter data for node %d: ", i);
        scanf("%d", &value);

        newnode = (struct node *)malloc(sizeof(struct node));
        newnode->data = value;

        if (head == NULL) {
            head = newnode;
            newnode->next = head;
            newnode->prev = head;
            temp = head;
        } else {
            newnode->next = head;
            newnode->prev = temp;
            temp->next = newnode;
            head->prev = newnode;
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
