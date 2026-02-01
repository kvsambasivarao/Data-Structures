/* File Name: circular_singly_linked_list.c
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
    struct Node *next;
};

struct Node *head = NULL;

// Insert at beginning
void insert_beg() {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    printf("Enter data: ");
    scanf("%d", &newNode->data);

    if (head == NULL) {
        head = newNode;
        newNode->next = head;
    } else {
        struct Node *temp = head;
        while (temp->next != head)
            temp = temp->next;
        newNode->next = head;
        temp->next = newNode;
        head = newNode;
    }
}

// Insert at end
void insert_end() {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    printf("Enter data: ");
    scanf("%d", &newNode->data);

    if (head == NULL) {
        head = newNode;
        newNode->next = head;
    } else {
        struct Node *temp = head;
        while (temp->next != head)
            temp = temp->next;
        temp->next = newNode;
        newNode->next = head;
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
        struct Node *temp = head;
        while (temp->next != head)
            temp = temp->next;
        struct Node *del = head;
        head = head->next;
        temp->next = head;
        free(del);
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
        struct Node *temp = head, *prev = NULL;
        while (temp->next != head) {
            prev = temp;
            temp = temp->next;
        }
        prev->next = head;
        free(temp);
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
        printf("%d -> ", temp->data);
        temp = temp->next;
    } while (temp != head);
    printf("(back to head)\n");
}
