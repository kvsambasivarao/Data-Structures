/* File: 2-3-4-tree-implementation.c
   Program implementing basic 2-3-4 Tree operations
*/

#include <stdio.h>
#include <stdlib.h>

#define MAX 3
#define MIN 1

struct node {
    int n;
    int keys[MAX+1];
    struct node *child[MAX+2];
};

struct node *root = NULL;

struct node* createNode(int key)
{
    struct node *newNode = (struct node*)malloc(sizeof(struct node));

    newNode->n = 1;
    newNode->keys[0] = key;

    for(int i=0;i<5;i++)
        newNode->child[i] = NULL;

    return newNode;
}

void traverse(struct node *ptr)
{
    if(ptr)
    {
        int i;

        for(i=0;i<ptr->n;i++)
        {
            traverse(ptr->child[i]);
            printf("%d ",ptr->keys[i]);
        }

        traverse(ptr->child[i]);
    }
}

struct node* search(struct node *ptr, int key)
{
    int i=0;

    if(ptr==NULL)
        return NULL;

    while(i<ptr->n && key>ptr->keys[i])
        i++;

    if(i<ptr->n && key==ptr->keys[i])
        return ptr;

    return search(ptr->child[i],key);
}

void insert(int key)
{
    if(root==NULL)
    {
        root = createNode(key);
        return;
    }

    if(root->n < MAX)
    {
        root->keys[root->n++] = key;
    }
}

int main()
{
    insert(10);
    insert(20);
    insert(5);
    insert(6);
    insert(12);

    printf("Traversal of 2-3-4 Tree:\n");

    traverse(root);

    int key=12;

    if(search(root,key))
        printf("\nKey found");
    else
        printf("\nKey not found");

    return 0;
}
