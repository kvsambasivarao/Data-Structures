/* File: fibonacci_delete_node.c
   Program: Delete a node in a Fibonacci Heap
*/

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct node {
    int key;
    struct node *left;
    struct node *right;
} Node;

Node *min = NULL;

Node* createNode(int key)
{
    Node *n = (Node*)malloc(sizeof(Node));
    n->key = key;
    n->left = n;
    n->right = n;
    return n;
}

Node* insert(Node *min, int key)
{
    Node *n = createNode(key);

    if (min == NULL)
        return n;

    n->left = min;
    n->right = min->right;
    min->right->left = n;
    min->right = n;

    if (n->key < min->key)
        min = n;

    return min;
}

void decreaseKey(Node *x, int newKey)
{
    x->key = newKey;

    if (x->key < min->key)
        min = x;
}

void extractMin()
{
    if (min == NULL)
        return;

    Node *temp = min;

    if (temp->right == temp)
        min = NULL;
    else
    {
        temp->left->right = temp->right;
        temp->right->left = temp->left;
        min = temp->right;
    }

    printf("Deleted node with key %d\n", temp->key);
    free(temp);
}

void deleteNode(Node *x)
{
    decreaseKey(x, INT_MIN);
    extractMin();
}

int main()
{
    Node *n1 = createNode(10);
    Node *n2 = createNode(20);

    min = insert(min, n1->key);
    min = insert(min, n2->key);

    deleteNode(n2);

    return 0;
}
