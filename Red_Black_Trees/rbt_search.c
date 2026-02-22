/* File: rbt_search.c */

#include <stdio.h>
#include <stdlib.h>

#define RED 0
#define BLACK 1

typedef struct Node {
    int data;
    int color;
    struct Node *left, *right, *parent;
} Node;

Node* createNode(int data) {
    Node* node = (Node*)malloc(sizeof(Node));
    node->data = data;
    node->color = RED;
    node->left = node->right = node->parent = NULL;
    return node;
}

Node* search(Node* root, int key) {
    if (root == NULL || root->data == key)
        return root;

    if (key < root->data)
        return search(root->left, key);
    else
        return search(root->right, key);
}

int main() {

    /* Simple manually created Red-Black Tree (BST structure only for search demo) */

    Node* root = createNode(20);
    root->color = BLACK;

    root->left = createNode(10);
    root->right = createNode(30);

    root->left->parent = root;
    root->right->parent = root;

    int key = 10;
    Node* result = search(root, key);

    if (result)
        printf("Key %d found in Red-Black Tree.\n", key);
    else
        printf("Key %d not found in Red-Black Tree.\n", key);

    return 0;
}
