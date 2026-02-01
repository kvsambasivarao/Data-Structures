// File Name: delete_beg.c
// Program to delete the first node of a singly linked list

#include <stdio.h>
#include <stdlib.h>

// Definition of node
struct node {
    int data;
    struct node *next;
};

struct node *head = NULL;

// Function to delete beginning node
void delete_beg() {
    struct node *temp;
    if (head == NULL) {
        printf("List is empty. Deletion not possible.\n");
        return;
    }
    temp = head;
    head = head->next;
    free(temp);
    printf("First node deleted successfully.\n");
}

int main() {
    delete_beg();
    return 0;
}
