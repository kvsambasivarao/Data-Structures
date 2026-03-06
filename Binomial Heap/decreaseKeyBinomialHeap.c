/* File: decreaseKeyBinomialHeap.c */

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int key;
    struct Node *parent;
    struct Node *child;
    struct Node *sibling;
} Node;

/* Create new node */
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

/* Decrease key operation */
void decreaseKey(Node *node, int newKey){

    if(newKey > node->key){
        printf("New key is greater than current key\n");
        return;
    }

    node->key = newKey;

    Node *parent = node->parent;

    while(parent != NULL && node->key < parent->key){
        swap(&node->key, &parent->key);
        node = parent;
        parent = node->parent;
    }
}

int main(){

    Node *root = newNode(10);
    Node *c1 = newNode(20);
    Node *c2 = newNode(30);

    root->child = c1;
    c1->sibling = c2;

    c1->parent = root;
    c2->parent = root;

    printf("Before decrease: %d\n", c1->key);

    decreaseKey(c1, 5);

    printf("After decrease: %d\n", root->key);

    return 0;
}
