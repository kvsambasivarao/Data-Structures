/* File: fibonacci_heap.c
   Program: Create a Fibonacci Heap and insert nodes
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int key;
    int degree;
    struct node *parent;
    struct node *child;
    struct node *left;
    struct node *right;
} Node;

Node *min = NULL;

Node* createNode(int key)
{
    Node *n = (Node*)malloc(sizeof(Node));
    n->key = key;
    n->degree = 0;
    n->parent = NULL;
    n->child = NULL;
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

void display()
{
    Node *temp = min;
    if (temp == NULL)
        return;

    printf("Root List: ");
    do
    {
        printf("%d ", temp->key);
        temp = temp->right;
    }
    while (temp != min);
    printf("\n");
}

int main()
{
    insert(10);
    insert(3);
    insert(15);
    insert(6);

    display();

    return 0;
}
