/* File: deleteKeyBinomialHeap.c */

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct Node {
    int key;
    struct Node *parent, *child, *sibling;
} Node;

/* Create node */
Node* newNode(int key){
    Node* temp = (Node*)malloc(sizeof(Node));
    temp->key = key;
    temp->parent = temp->child = temp->sibling = NULL;
    return temp;
}

/* Swap keys */
void swap(int *a, int *b){
    int t = *a;
    *a = *b;
    *b = t;
}

/* Decrease key */
void decreaseKey(Node *node, int newKey){

    node->key = newKey;
    Node *parent = node->parent;

    while(parent != NULL && node->key < parent->key){
        swap(&node->key, &parent->key);
        node = parent;
        parent = node->parent;
    }
}

/* Extract minimum */
Node* extractMin(Node* heap){

    Node *min = heap;
    Node *prevMin = NULL;
    Node *prev = NULL;
    Node *curr = heap;

    while(curr){
        if(curr->key < min->key){
            min = curr;
            prevMin = prev;
        }
        prev = curr;
        curr = curr->sibling;
    }

    if(prevMin)
        prevMin->sibling = min->sibling;
    else
        heap = min->sibling;

    printf("Deleted key: %d\n", min->key);

    return heap;
}

/* Delete operation */
Node* deleteKey(Node *heap, Node *node){

    decreaseKey(node, INT_MIN);
    heap = extractMin(heap);

    return heap;
}

int main(){

    Node *root = newNode(10);
    Node *c1 = newNode(20);
    Node *c2 = newNode(30);

    root->child = c1;
    c1->sibling = c2;

    c1->parent = root;
    c2->parent = root;

    Node *heap = root;

    heap = deleteKey(heap, c1);

    return 0;
}
