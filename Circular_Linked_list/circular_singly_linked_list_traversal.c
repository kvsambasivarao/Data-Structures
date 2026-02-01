// File Name: circular_singly_linked_list_traversal.c
// Program to traverse a circular singly linked list
// left to right and right to left (using recursion)

#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};

struct node *head = NULL;

// Left to Right traversal
void traverse_forward() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct node *temp = head;
    printf("Left to Right: ");
    do {
        printf("%d -> ", temp->data);
        temp = temp->next;
    } while (temp != head);
    printf("HEAD\n");
}

// Recursive helper for reverse traversal
void traverse_reverse_util(struct node *current, struct node *start) {
    if (current->next != start)
        traverse_reverse_util(current->next, start);

    printf("%d -> ", current->data);
}

// Right to Left traversal
void traverse_backward() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    printf("Right to Left: ");
    traverse_reverse_util(head, head);
    printf("HEAD\n");
}

int main() {
    traverse_forward();
    traverse_backward();
    return 0;
}
