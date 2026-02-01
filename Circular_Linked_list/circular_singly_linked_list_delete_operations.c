// File Name: circular_singly_linked_list_delete_operations.c
// Program to delete a node at beginning, end, and given position
// in a circular singly linked list

#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
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

    // Only one node
    if (head->next == head) {
        free(head);
        head = NULL;
        return;
    }

    struct node *last = head;
    while (last->next != head)
        last = last->next;

    head = head->next;
    last->next = head;
    free(temp);
}

// Delete at end
void delete_end() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    // Only one node
    if (head->next == head) {
        free(head);
        head = NULL;
        return;
    }

    struct node *temp = head, *prev = NULL;
    while (temp->next != head) {
        prev = temp;
        temp = temp->next;
    }

    prev->next = head;
    free(temp);
}

// Delete at given position (1-based)
void delete_pos(int pos) {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    if (pos == 1) {
        delete_beg();
        return;
    }

    struct node *temp = head, *prev = NULL;
    int i;

    for (i = 1; i < pos && temp->next != head; i++) {
        prev = temp;
        temp = temp->next;
    }

    if (i != pos) {
        printf("Invalid position\n");
        return;
    }

    prev->next = temp->next;
    free(temp);
}

int main() {
    delete_beg();
    delete_end();
    delete_pos(2);
    return 0;
}
