// File Name: circular_doubly_linked_list_insert_operations.c
// Program to insert a node at beginning, end, and given position
// in a circular doubly linked list

#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *prev;
    struct node *next;
};

struct node *head = NULL;

// Insert at beginning
void insert_beg(int value) {
    struct node *newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = value;

    if (head == NULL) {
        newnode->next = newnode;
        newnode->prev = newnode;
        head = newnode;
        return;
    }

    struct node *last = head->prev;

    newnode->next = head;
    newnode->prev = last;
    last->next = newnode;
    head->prev = newnode;
    head = newnode;
}

// Insert at end
void insert_end(int value) {
    struct node *newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = value;

    if (head == NULL) {
        newnode->next = newnode;
        newnode->prev = newnode;
        head = newnode;
        return;
    }

    struct node *last = head->prev;

    newnode->next = head;
    newnode->prev = last;
    last->next = newnode;
    head->prev = newnode;
}

// Insert at given position (1-based)
void insert_pos(int value, int pos) {
    if (head == NULL || pos == 1) {
        insert_beg(value);
        return;
    }

    struct node *temp = head;
    int i;

    for (i = 1; i < pos - 1 && temp->next != head; i++)
        temp = temp->next;

    struct node *newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = value;

    newnode->next = temp->next;
    newnode->prev = temp;
    temp->next->prev = newnode;
    temp->next = newnode;
}

int main() {
    insert_beg(10);
    insert_end(30);
    insert_pos(20, 2);
    return 0;
}
