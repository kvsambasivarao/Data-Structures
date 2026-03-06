/* File: extractMinBinomialHeap.c */

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int key, degree;
    struct Node *parent, *child, *sibling;
} Node;

/* Create new node */
Node* newNode(int key){
    Node* temp = (Node*)malloc(sizeof(Node));
    temp->key = key;
    temp->degree = 0;
    temp->parent = temp->child = temp->sibling = NULL;
    return temp;
}

/* Find minimum root */
Node* findMin(Node* head){

    Node *min = head;
    Node *curr = head;

    while(curr){
        if(curr->key < min->key)
            min = curr;
        curr = curr->sibling;
    }

    return min;
}

/* Reverse child list */
Node* reverse(Node* node){

    Node *prev = NULL;
    Node *curr = node;
    Node *next;

    while(curr){
        next = curr->sibling;
        curr->sibling = prev;
        curr->parent = NULL;
        prev = curr;
        curr = next;
    }

    return prev;
}

/* Extract minimum */
Node* extractMin(Node* heap){

    if(heap == NULL)
        return NULL;

    Node *min = heap;
    Node *minPrev = NULL;
    Node *prev = NULL;
    Node *curr = heap;

    while(curr){

        if(curr->key < min->key){
            min = curr;
            minPrev = prev;
        }

        prev = curr;
        curr = curr->sibling;
    }

    if(minPrev)
        minPrev->sibling = min->sibling;
    else
        heap = min->sibling;

    Node *childHeap = reverse(min->child);

    printf("Extracted Min: %d\n", min->key);

    return childHeap;   /* simplified illustration */
}

int main(){

    Node *h1 = newNode(10);
    Node *h2 = newNode(5);
    Node *h3 = newNode(20);

    h1->sibling = h2;
    h2->sibling = h3;

    Node *heap = h1;

    heap = extractMin(heap);

    return 0;
}
