/* File: fibonacci_marking.c
   Program: Demonstrate node marking and cascading cut in Fibonacci Heap
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Node {
    int key;
    int mark;
    struct Node *parent;
    struct Node *child;
} Node;

Node* createNode(int key)
{
    Node* n = (Node*)malloc(sizeof(Node));
    n->key = key;
    n->mark = 0;
    n->parent = NULL;
    n->child = NULL;
    return n;
}

void cut(Node *child, Node *parent)
{
    printf("Cut node %d from parent %d\n", child->key, parent->key);

    child->parent = NULL;

    if(parent->mark == 0)
    {
        parent->mark = 1;
        printf("Node %d marked (first child cut)\n", parent->key);
    }
    else
    {
        printf("Node %d cut due to second child loss (cascading cut)\n", parent->key);
    }
}

int main()
{
    Node *parent = createNode(10);
    Node *child1 = createNode(20);
    Node *child2 = createNode(30);

    child1->parent = parent;
    child2->parent = parent;

    cut(child1, parent);  
    cut(child2, parent);  

    return 0;
}
