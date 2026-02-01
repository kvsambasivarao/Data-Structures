// File Name: singly_linked_list_count_nodes_recursive.c
// Program to count the number of nodes in a singly linked list using recursion

#include <stdio.h>
#include <stdlib.h>

// Definition of node
struct node {
    int data;
    struct node *next;
};

struct node *head = NULL;

// Recursive function to count nodes
int count_nodes(struct node *temp) {
    if (temp == NULL)
        return 0;
    return 1 + count_nodes(temp->next);
}

int main() {
    printf("Number of nodes = %d\n", count_nodes(head));
    return 0;
}
