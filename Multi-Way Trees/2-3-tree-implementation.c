/* File: 2-3-tree-implementation.c
   Program to implement 2-3 Tree operations
*/

#include <stdio.h>
#include <stdlib.h>

#define MAX 2
#define MIN 1

struct node {
    int n;
    int keys[MAX+1];
    struct node *child[MAX+2];
};

struct node *root = NULL;

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
    int i;

    if(ptr == NULL)
        return NULL;

    for(i=0;i<ptr->n;i++)
    {
        if(key == ptr->keys[i])
            return ptr;
    }

    if(key < ptr->keys[0])
        return search(ptr->child[0],key);
    else if(ptr->n==1 || key < ptr->keys[1])
        return search(ptr->child[1],key);
    else
        return search(ptr->child[2],key);
}

void insertSimple(struct node *ptr,int key)
{
    ptr->keys[ptr->n++] = key;
}

void insert(int key)
{
    if(root==NULL)
    {
        root = (struct node*)malloc(sizeof(struct node));
        root->n = 1;
        root->keys[0] = key;
        root->child[0] = root->child[1] = NULL;
        return;
    }

    insertSimple(root,key);
}

int main()
{
    insert(10);
    insert(20);
    insert(5);
    insert(15);

    printf("Traversal of 2-3 Tree:\n");
    traverse(root);

    int key=15;

    if(search(root,key))
        printf("\nKey found");
    else
        printf("\nKey not found");

    return 0;
}
