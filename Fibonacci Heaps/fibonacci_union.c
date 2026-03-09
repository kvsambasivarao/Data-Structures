/* File: fibonacci_union.c
   Program: Illustrate union of two Fibonacci Heaps
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int key;
    struct node *left;
    struct node *right;
} Node;

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

Node* unionHeap(Node *min1, Node *min2)
{
    if (min1 == NULL) return min2;
    if (min2 == NULL) return min1;

    Node *temp = min1->right;
    min1->right = min2->right;
    min2->right->left = min1;
    min2->right = temp;
    temp->left = min2;

    if (min2->key < min1->key)
        return min2;
    else
        return min1;
}

void display(Node *min)
{
    Node *temp = min;
    if (temp == NULL) return;

    printf("Heap nodes: ");
    do {
        printf("%d ", temp->key);
        temp = temp->right;
    } while (temp != min);
    printf("\n");
}

int main()
{
    Node *H1 = NULL;
    Node *H2 = NULL;

    H1 = insert(H1, 10);
    H1 = insert(H1, 3);
    H1 = insert(H1, 15);

    H2 = insert(H2, 7);
    H2 = insert(H2, 2);
    H2 = insert(H2, 18);

    Node *H = unionHeap(H1, H2);

    display(H);

    return 0;
}
