// File Name: circular_singly_linked_list_insert_operations.c
// Program to insert a node at beginning, end, and given position
// in a circular singly linked list

#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};

struct node *head = NULL;

// Insert at beginning
void insert_beg(int value) {
    struct node *newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = value;

    if (head == NULL) {
        head = newnode;
        newnode->next = head;
        return;
    }

    struct node *temp = head;
    while (temp->next != head)
        temp = temp->next;

    newnode->next = head;
    temp->next = newnode;
    head = newnode;
}

// Insert at end
void insert_end(int value) {
    struct node *newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = value;

    if (head == NULL) {
        head = newnode;
        newnode->next = head;
        return;
    }

    struct node *temp = head;
    while (temp->next != head)
        temp = temp->next;

    temp->next = newnode;
    newnode->next = head;
}

// Insert at given position (1-based)
void insert_pos(int value, int pos) {
    if (head == NULL || pos == 1) {
        insert_beg(value);
        return;
    }

    struct node *newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = value;

    struct node *temp = head;
    int i;
    for (i = 1; i < pos - 1 && temp->next != head; i++)
        temp = temp->next;

    newnode->next = temp->next;
    temp->next = newnode;
}

int main() {
    insert_beg(10);
    insert_end(20);
    insert_pos(15, 2);
    return 0;
}
