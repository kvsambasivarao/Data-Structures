/* File: fibonacci_insert.c
   Program: Insert a node into a Fibonacci Heap
*/

#include <stdio.h>
#include <stdlib.h>

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

    printf("Inserted node %d\n", key);
}

int main()
{
    insert(10);
    insert(4);
    insert(15);
    insert(2);

    printf("Current minimum key: %d\n", min->key);

    return 0;
}
