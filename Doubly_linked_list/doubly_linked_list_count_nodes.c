// File Name: doubly_linked_list_count_nodes.c
// Program to count the number of nodes in a doubly linked list

#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *prev;
    struct node *next;
};

struct node *head = NULL;

// Function to count nodes
int count_nodes() {
    int count = 0;
    struct node *temp = head;

    while (temp != NULL) {
        count++;
        temp = temp->next;
    }
    return count;
}

int main() {
    printf("Number of nodes = %d\n", count_nodes());
    return 0;
}
