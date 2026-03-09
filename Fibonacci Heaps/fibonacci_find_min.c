/* File: fibonacci_find_min.c
   Program: Find the minimum key in a Fibonacci Heap
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
}

void findMin()
{
    if (min == NULL)
        printf("Heap is empty\n");
    else
        printf("Minimum key in Fibonacci Heap: %d\n", min->key);
}

int main()
{
    insert(10);
    insert(3);
    insert(15);
    insert(6);

    findMin();

    return 0;
}
