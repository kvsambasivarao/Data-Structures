/* File: fibonacci_increase_key.c
   Program: Increase a key value in a Fibonacci Heap
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

void increaseKey(Node *x, int newKey)
{
    if (newKey < x->key)
    {
        printf("New key is smaller than current key\n");
        return;
    }

    x->key = newKey;
    printf("Key increased to %d\n", newKey);
}

int main()
{
    Node *n1 = createNode(10);

    min = insert(min, 10);

    increaseKey(n1, 25);

    return 0;
}
