// File Name: double_threaded_binary_tree.c

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node *left, *right;
    int lTag;  // 0 = left child, 1 = predecessor thread
    int rTag;  // 0 = right child, 1 = successor thread
} Node;

Node* createNode(int key) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = key;
    newNode->left = NULL;
    newNode->right = NULL;
    newNode->lTag = 1;
    newNode->rTag = 1;
    return newNode;
}

Node* insert(Node* root, int key) {
    Node *parent = NULL, *current = root;

    while (current != NULL) {
        if (key == current->data)
            return root;

        parent = current;

        if (key < current->data) {
            if (current->lTag == 0)
                current = current->left;
            else
                break;
        } else {
            if (current->rTag == 0)
                current = current->right;
            else
                break;
        }
    }

    Node* newNode = createNode(key);

    if (parent == NULL) {
        root = newNode;
    }
    else if (key < parent->data) {
        newNode->left = parent->left;
        newNode->right = parent;
        parent->lTag = 0;
        parent->left = newNode;
    }
    else {
        newNode->right = parent->right;
        newNode->left = parent;
        parent->rTag = 0;
        parent->right = newNode;
    }

    return root;
}

Node* leftMost(Node* node) {
    while (node && node->lTag == 0)
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
