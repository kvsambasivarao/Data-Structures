/* File: increaseKeyBinomialHeap.c */

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int key;
    struct Node *parent;
    struct Node *child;
    struct Node *sibling;
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

/* Restore heap property downward */
void heapifyDown(Node *node){

    while(node->child){

        Node *minChild = node->child;
        Node *curr = minChild->sibling;

        while(curr){
            if(curr->key < minChild->key)
                minChild = curr;
            curr = curr->sibling;
        }

        if(node->key <= minChild->key)
            break;

        swap(&node->key, &minChild->key);
        node = minChild;
    }
}

/* Increase key operation */
void increaseKey(Node *node, int newKey){

    if(newKey < node->key){
        printf("New key is smaller than current key\n");
        return;
    }

    node->key = newKey;
    heapifyDown(node);
}

int main(){

    Node *root = newNode(10);
    Node *c1 = newNode(20);
    Node *c2 = newNode(30);

    root->child = c1;
    c1->sibling = c2;

    c1->parent = root;
    c2->parent = root;

    printf("Before increase: %d\n", c1->key);

    increaseKey(c1, 40);

    printf("After increase: %d\n", c1->key);

    return 0;
}
