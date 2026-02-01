/* File Name: singly_linked_list.c */

#include <stdio.h>
#include <stdlib.h>

// Node definition
struct Node {
    int data;
    struct Node *next;
};

struct Node *head = NULL;

// Insert at beginning
void insert_beg() {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    printf("Enter data: ");
    scanf("%d", &newNode->data);
    newNode->next = head;
    head = newNode;
}

// Insert at end
void insert_end() {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    struct Node *temp = head;

    printf("Enter data: ");
    scanf("%d", &newNode->data);
    newNode->next = NULL;

    if (head == NULL) {
        head = newNode;
        return;
    }

    while (temp->next != NULL)
        temp = temp->next;

    temp->next = newNode;
}

// Delete from beginning
void delete_beg() {
    struct Node *temp;
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }
    temp = head;
    head = head->next;
    free(temp);
}

// Delete from end
void delete_end() {
    struct Node *temp = head, *prev = NULL;

    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    if (head->next == NULL) {
        free(head);
        head = NULL;
        return;
    }

    while (temp->next != NULL) {
        prev = temp;
        temp = temp->next;
    }
    prev->next = NULL;
    free(temp);
}

// Display list
void display() {
    struct Node *temp = head;
    if (temp == NULL) {
        printf("List is empty\n");
        return;
    }
    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}
