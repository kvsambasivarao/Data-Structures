/* File: threaded_binary_tree.c */

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node *left, *right;
    int lthread, rthread;
} Node;

Node* createNode(int data) {
    Node* node = (Node*)malloc(sizeof(Node));
    node->data = data;
    node->left = node->right = NULL;
    node->lthread = node->rthread = 1;
    return node;
}

Node* insert(Node* root, int key) {
    Node *parent = NULL, *current = root;

    while (current != NULL) {
        if (key == current->data)
            return root;

        parent = current;

        if (key < current->data) {
            if (current->lthread == 0)
                current = current->left;
            else
                break;
        } else {
            if (current->rthread == 0)
                current = current->right;
            else
                break;
        }
    }

    Node* node = createNode(key);

    if (parent == NULL) {
        root = node;
        node->left = node->right = NULL;
    } else if (key < parent->data) {
        node->left = parent->left;
        node->right = parent;
        parent->lthread = 0;
        parent->left = node;
    } else {
        node->left = parent;
        node->right = parent->right;
        parent->rthread = 0;
        parent->right = node;
    }

    return root;
}

Node* inorderSuccessor(Node* ptr) {
    if (ptr->rthread)
        return ptr->right;

    ptr = ptr->right;
    while (!ptr->lthread)
        ptr = ptr->left;

    return ptr;
}

void inorder(Node* root) {
    if (root == NULL) return;

    Node* current = root;

    while (!current->lthread)
        current = current->left;

    while (current != NULL) {
        printf("%d ", current->data);
        current = inorderSuccessor(current);
    }
}

Node* search(Node* root, int key) {
    Node* current = root;

    while (current != NULL) {
        if (key == current->data)
            return current;

        if (key < current->data) {
            if (!current->lthread)
                current = current->left;
            else
                break;
        } else {
            if (!current->rthread)
                current = current->right;
            else
                break;
        }
    }
    return NULL;
}

/* Simplified delete: removes leaf node only for demonstration */
Node* delete(Node* root, int key) {
    Node *parent = NULL, *current = root;

    while (current != NULL && current->data != key) {
        parent = current;
        if (key < current->data) {
            if (!current->lthread)
                current = current->left;
            else
                return root;
        } else {
            if (!current->rthread)
                current = current->right;
            else
                return root;
        }
    }

    if (current == NULL)
        return root;

    if (!current->lthread || !current->rthread) {
        printf("Deletion of non-leaf nodes not implemented.\n");
        return root;
    }

    if (parent == NULL)
        root = NULL;
    else if (parent->left == current) {
        parent->lthread = 1;
        parent->left = current->left;
    } else {
        parent->rthread = 1;
        parent->right = current->right;
    }

    free(current);
    return root;
}

int main() {
    Node* root = NULL;

    root = insert(root, 20);
    root = insert(root, 10);
    root = insert(root, 30);
    root = insert(root, 25);

    printf("Inorder Traversal:\n");
    inorder(root);

    printf("\nSearching 25:\n");
    if (search(root, 25))
        printf("Found\n");

    root = delete(root, 25);

    printf("Inorder after deletion:\n");
    inorder(root);

    return 0;
}
