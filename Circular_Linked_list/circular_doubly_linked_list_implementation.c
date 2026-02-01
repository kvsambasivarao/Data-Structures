// File Name: circular_doubly_linked_list.c
// Program to implement a circular doubly linked list with basic operations

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

// Delete at beginning
void delete_beg() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

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

// Traverse forward
void traverse_forward() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct node *temp = head;
    printf("Forward: ");
    do {
        printf("%d <-> ", temp->data);
        temp = temp->next;
    } while (temp != head);
    printf("HEAD\n");
}

// Traverse backward
void traverse_backward() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct node *temp = head->prev;
    printf("Backward: ");
    do {
        printf("%d <-> ", temp->data);
        temp = temp->prev;
    } while (temp != head->prev);
    printf("HEAD\n");
}

int main() {
    insert_beg(10);
    insert_end(20);
    insert_end(30);

    traverse_forward();
    traverse_backward();

    delete_beg();
    delete_end();

    traverse_forward();
    return 0;
}
