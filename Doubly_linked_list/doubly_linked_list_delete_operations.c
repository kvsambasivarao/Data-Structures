// File Name: doubly_linked_list_delete_operations.c
// Program to delete nodes at beginning, end, and given position in a doubly linked list

#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *prev;
    struct node *next;
};

struct node *head = NULL;

// Delete at beginning
void delete_beg() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }
    struct node *temp = head;
    head = head->next;
    if (head != NULL)
        head->prev = NULL;
    free(temp);
}

// Delete at end
void delete_end() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }
    struct node *temp = head;
    if (temp->next == NULL) {
        free(temp);
        head = NULL;
        return;
    }
    while (temp->next != NULL)
        temp = temp->next;
    temp->prev->next = NULL;
    free(temp);
}

// Delete at given position
void delete_pos(int pos) {
    struct node *temp = head;
    int i;

    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    if (pos == 1) {
        delete_beg();
        return;
    }

    for (i = 1; i < pos && temp != NULL; i++)
        temp = temp->next;

    if (temp == NULL) {
        printf("Invalid position\n");
        return;
    }

    if (temp->next != NULL)
        temp->next->prev = temp->prev;

    temp->prev->next = temp->next;
    free(temp);
}

int main() {
    delete_beg();
    delete_end();
    delete_pos(2);
    return 0;
}
