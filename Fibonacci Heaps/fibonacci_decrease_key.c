/* File: fibonacci_decrease_key.c
   Program: Decrease a key value in a Fibonacci Heap
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int key;
    struct node *parent;
    struct node *left;
    struct node *right;
} Node;

Node *min = NULL;

Node* createNode(int key)
{
    Node *n = (Node*)malloc(sizeof(Node));
    n->key = key;
    n->parent = NULL;
    n->left = n;
    n->right = n;
    return n;
}

void insert(int key)
{
    Node *n = createNode(key);

    if (min == NULL)
        min = n;
    else
    {
        n->left = min;
        n->right = min->right;
        min->right->left = n;
        min->right = n;

        if (n->key < min->key)
            min = n;
    }
}

void decreaseKey(Node *x, int newKey)
{
    if (newKey > x->key)
    {
        printf("New key is greater than current key\n");
        return;
    }

    x->key = newKey;

    if (x->key < min->key)
        min = x;

    printf("Key decreased to %d\n", newKey);
}

int main()
{
    Node *n1 = createNode(10);
    Node *n2 = createNode(20);

    insert(n1->key);
    insert(n2->key);

    decreaseKey(n2, 5);

    printf("Current minimum key: %d\n", min->key);

    return 0;
}
