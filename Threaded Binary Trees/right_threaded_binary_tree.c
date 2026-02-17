// File Name: right_threaded_binary_tree.c

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node *left, *right;
    int rTag;   // 0 = right child, 1 = thread
} Node;

Node* createNode(int key) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = key;
    newNode->left = NULL;
    newNode->right = NULL;
    newNode->rTag = 1;
    return newNode;
}

Node* insert(Node* root, int key) {
    Node *parent = NULL, *current = root;

    while (current != NULL) {
        parent = current;
        if (key < current->data) {
            if (current->left != NULL)
                current = current->left;
            else break;
        } else {
            if (current->rTag == 0)
                current = current->right;
            else break;
        }
    }

    Node* newNode = createNode(key);

    if (parent == NULL)
        root = newNode;
    else if (key < parent->data) {
        parent->left = newNode;
        newNode->right = parent;
    } else {
        newNode->right = parent->right;
        parent->right = newNode;
        parent->rTag = 0;
    }

    return root;
}

Node* leftMost(Node* node) {
    while (node && node->left != NULL)
        node = node->left;
    return node;
}

void inorder(Node* root) {
    Node* current = leftMost(root);

    while (current != NULL) {
        printf("%d ", current->data);
        if (current->rTag == 1)
            current = current->right;
        else
            current = leftMost(current->right);
    }
}

int main() {
    Node* root = NULL;
    root = insert(root, 15);
    insert(root, 12);
    insert(root, 22);
    insert(root, 8);
    insert(root, 14);

    printf("Inorder Traversal:\n");
    inorder(root);
    return 0;
}
