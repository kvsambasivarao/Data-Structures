// File Name: circular_doubly_linked_list_delete_operations.c
// Program to delete a node at beginning, end, and given position
// in a circular doubly linked list

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

    // Only one node
    if (head->next == head) {
        free(head);
        head = NULL;
        return;
    }

    struct node *last = head->prev;
    struct node *temp = head;

    head = head->next;
    head->prev = last;
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

    struct node *last = head->prev;
    struct node *second_last = last->prev;

    second_last->next = head;
    head->prev = second_last;
    free(last);
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

    struct node *temp = head;
    int i;

    for (i = 1; i < pos && temp->next != head; i++)
        temp = temp->next;

    if (i != pos) {
        printf("Invalid position\n");
        return;
    }

    temp->prev->next = temp->next;
    temp->next->prev = temp->prev;
    free(temp);
}

int main() {
    delete_beg();
    delete_end();
    delete_pos(2);
    return 0;
}
