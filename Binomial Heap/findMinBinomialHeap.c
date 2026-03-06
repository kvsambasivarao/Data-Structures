/* File: findMinBinomialHeap.c */

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int key;
    struct Node *sibling;
} Node;

/* Function to find minimum key in root list */
Node* findMin(Node* head) {
    if (head == NULL)
        return NULL;

    Node* minNode = head;
    Node* curr = head->sibling;

    while (curr != NULL) {
        if (curr->key < minNode->key)
            minNode = curr;

        curr = curr->sibling;
    }

    return minNode;
}

int main() {

    /* Creating a sample root list of binomial heap */
    Node *n1 = (Node*)malloc(sizeof(Node));
    Node *n2 = (Node*)malloc(sizeof(Node));
    Node *n3 = (Node*)malloc(sizeof(Node));

    n1->key = 10;
    n2->key = 5;
    n3->key = 20;

    n1->sibling = n2;
    n2->sibling = n3;
    n3->sibling = NULL;

    Node* min = findMin(n1);

    if(min != NULL)
        printf("Minimum key in Binomial Heap: %d\n", min->key);

    return 0;
}
