/* File: fibonacci_cascading_cut.c
   Program: Demonstrate Cascading Cut in Fibonacci Heap
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int key;
    int mark;
    struct Node *parent;
} Node;

Node* createNode(int key)
{
    Node* n = (Node*)malloc(sizeof(Node));
    n->key = key;
    n->mark = 0;
    n->parent = NULL;
    return n;
}

void cascadingCut(Node *y)
{
    Node *z = y->parent;

    if (z != NULL)
    {
        if (y->mark == 0)
        {
            y->mark = 1;
            printf("Node %d marked\n", y->key);
        }
        else
        {
            printf("Cascading cut: node %d cut from parent %d\n", y->key, z->key);
            y->parent = NULL;
            cascadingCut(z);
        }
    }
}

int main()
{
    Node *parent = createNode(10);
    Node *child = createNode(20);

    child->parent = parent;

    cascadingCut(child);
    cascadingCut(child);

    return 0;
}
