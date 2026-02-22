/* File: rbt_rotate.c */

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    int color;   // 0 = RED, 1 = BLACK
    struct Node *left, *right, *parent;
} Node;

Node* createNode(int data) {
    Node* node = (Node*)malloc(sizeof(Node));
    node->data = data;
    node->color = 0;
    node->left = node->right = node->parent = NULL;
    return node;
}

void leftRotate(Node **root, Node *x) {
    Node *y = x->right;

    x->right = y->left;
    if (y->left != NULL)
        y->left->parent = x;

    y->parent = x->parent;

    if (x->parent == NULL)
        *root = y;
    else if (x == x->parent->left)
        x->parent->left = y;
    else
        x->parent->right = y;

    y->left = x;
    x->parent = y;
}

void rightRotate(Node **root, Node *y) {
    Node *x = y->left;

    y->left = x->right;
    if (x->right != NULL)
        x->right->parent = y;

    x->parent = y->parent;

    if (y->parent == NULL)
        *root = x;
    else if (y == y->parent->left)
        y->parent->left = x;
    else
        y->parent->right = x;

    x->right = y;
    y->parent = x;
}

int main() {

    Node *root = createNode(20);
    root->left = createNode(10);
    root->left->parent = root;

    printf("Rotation functions implemented successfully.\n");

    return 0;
}
