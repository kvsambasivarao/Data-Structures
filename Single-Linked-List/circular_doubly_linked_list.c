/* File Name: circular_doubly_linked_list.c
   Operations:
   1. Insert at beginning
   2. Insert at end
   3. Delete from beginning
   4. Delete from end
   5. Display list
*/

#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *prev;
    struct Node *next;
};

struct Node *head = NULL;

// Insert at beginning
void insert_beg() {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    printf("Enter data: ");
    scanf("%d", &newNode->data);

    if (head == NULL) {
        newNode->next = newNode;
        newNode->prev = newNode;
        head = newNode;
    } else {
        struct Node *last = head->prev;
        newNode->next = head;
        newNode->prev = last;
        last->next = newNode;
        head->prev = newNode;
        head = newNode;
    }
}

// Insert at end
void insert_end() {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    printf("Enter data: ");
    scanf("%d", &newNode->data);

    if (head == NULL) {
        newNode->next = newNode;
        newNode->prev = newNode;
        head = newNode;
    } else {
        struct Node *last = head->prev;
        newNode->next = head;
        newNode->prev = last;
        last->next = newNode;
        head->prev = newNode;
    }
}

// Delete from beginning
void delete_beg() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    if (head->next == head) {
        free(head);
        head = NULL;
    } else {
        struct Node *last = head->prev;
        struct Node *temp = head;
        head = head->next;
        head->prev = last;
        last->next = head;
        free(temp);
    }
}

// Delete from end
void delete_end() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    if (head->next == head) {
        free(head);
        head = NULL;
    } else {
        struct Node *last = head->prev;
        struct Node *prevNode = last->prev;
        prevNode->next = head;
        head->prev = prevNode;
        free(last);
    }
}

// Display list
void display() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct Node *temp = head;
    do {
        printf("%d <-> ", temp->data);
        temp = temp->next;
    } while (temp != head);
    printf("(back to head)\n");
}
