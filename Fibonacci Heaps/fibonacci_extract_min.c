/* File: fibonacci_extract_min.c
   Program: Illustrate extracting the minimum key from a Fibonacci Heap
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

void extractMin()
{
    if (min == NULL)
    {
        printf("Heap is empty\n");
        return;
    }

    Node *temp = min;
    printf("Extracted minimum key: %d\n", temp->key);

    if (temp->right == temp)
        min = NULL;
    else
    {
        temp->left->right = temp->right;
        temp->right->left = temp->left;
        min = temp->right;
    }

    free(temp);
}

void display()
{
    if (min == NULL)
    {
        printf("Heap is empty\n");
        return;
    }

    Node *temp = min;

    printf("Heap nodes: ");
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

    extractMin();

    display();

    return 0;
}
