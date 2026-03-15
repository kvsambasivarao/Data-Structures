/* File: btree.c
   Program to implement B-Tree operations (Search, Insert, Traverse)
*/

#include <stdio.h>
#include <stdlib.h>

#define T 3   // Minimum degree (order)

typedef struct BTreeNode {
    int keys[2*T-1];
    struct BTreeNode *children[2*T];
    int n;
    int leaf;
} BTreeNode;

BTreeNode* createNode(int leaf) {
    BTreeNode* node = (BTreeNode*)malloc(sizeof(BTreeNode));
    node->leaf = leaf;
    node->n = 0;
    for(int i=0;i<2*T;i++)
        node->children[i] = NULL;
    return node;
}

void traverse(BTreeNode *root) {
    int i;
    for(i=0;i<root->n;i++) {
        if(!root->leaf)
            traverse(root->children[i]);
        printf("%d ", root->keys[i]);
    }
    if(!root->leaf)
        traverse(root->children[i]);
}

BTreeNode* search(BTreeNode *root, int k) {
    int i=0;
    while(i<root->n && k>root->keys[i])
        i++;

    if(i<root->n && root->keys[i]==k)
        return root;

    if(root->leaf)
        return NULL;

    return search(root->children[i],k);
}

void splitChild(BTreeNode *x, int i, BTreeNode *y) {
    BTreeNode *z = createNode(y->leaf);
    z->n = T-1;

    for(int j=0;j<T-1;j++)
        z->keys[j] = y->keys[j+T];

    if(!y->leaf) {
        for(int j=0;j<T;j++)
            z->children[j] = y->children[j+T];
    }

    y->n = T-1;

    for(int j=x->n; j>=i+1; j--)
        x->children[j+1] = x->children[j];

    x->children[i+1] = z;

    for(int j=x->n-1; j>=i; j--)
        x->keys[j+1] = x->keys[j];

    x->keys[i] = y->keys[T-1];
    x->n++;
}

void insertNonFull(BTreeNode *x, int k) {
    int i = x->n - 1;

    if(x->leaf) {
        while(i>=0 && x->keys[i]>k) {
            x->keys[i+1] = x->keys[i];
            i--;
        }
        x->keys[i+1] = k;
        x->n++;
    }
    else {
        while(i>=0 && x->keys[i]>k)
            i--;

        i++;

        if(x->children[i]->n == 2*T-1) {
            splitChild(x,i,x->children[i]);
            if(k > x->keys[i])
                i++;
        }
        insertNonFull(x->children[i],k);
    }
}

void insert(BTreeNode **root, int k) {
    BTreeNode *r = *root;

    if(r->n == 2*T-1) {
        BTreeNode *s = createNode(0);
        *root = s;
        s->children[0] = r;

        splitChild(s,0,r);

        int i = 0;
        if(s->keys[0] < k)
            i++;

        insertNonFull(s->children[i],k);
    }
    else
        insertNonFull(r,k);
}

int main() {

    BTreeNode *root = createNode(1);

    insert(&root,10);
    insert(&root,20);
    insert(&root,5);
    insert(&root,6);
    insert(&root,12);
    insert(&root,30);
    insert(&root,7);
    insert(&root,17);

    printf("Traversal of B-Tree:\n");
    traverse(root);

    int key = 6;

    if(search(root,key))
        printf("\nKey %d found\n",key);
    else
        printf("\nKey %d not found\n",key);

    return 0;
}
