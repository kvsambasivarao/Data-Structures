/* File: unionBinomialHeap.c */

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int key, degree;
    struct Node *parent, *child, *sibling;
} Node;

/* Create new node */
Node* newNode(int k) {
    Node* temp = (Node*)malloc(sizeof(Node));
    temp->key = k;
    temp->degree = 0;
    temp->parent = temp->child = temp->sibling = NULL;
    return temp;
}

/* Merge root lists by degree */
Node* merge(Node* h1, Node* h2) {

    if(!h1) return h2;
    if(!h2) return h1;

    Node *head = NULL, *tail = NULL;

    if(h1->degree <= h2->degree) {
        head = tail = h1;
        h1 = h1->sibling;
    } else {
        head = tail = h2;
        h2 = h2->sibling;
    }

    while(h1 && h2) {
        if(h1->degree <= h2->degree) {
            tail->sibling = h1;
            h1 = h1->sibling;
        } else {
            tail->sibling = h2;
            h2 = h2->sibling;
        }
        tail = tail->sibling;
    }

    tail->sibling = (h1) ? h1 : h2;

    return head;
}

/* Link trees of same degree */
void linkTrees(Node* y, Node* z) {
    y->parent = z;
    y->sibling = z->child;
    z->child = y;
    z->degree++;
}

/* Union operation */
Node* unionHeap(Node* h1, Node* h2) {

    Node* head = merge(h1, h2);

    if(!head) return NULL;

    Node *prev = NULL;
    Node *curr = head;
    Node *next = curr->sibling;

    while(next != NULL) {

        if((curr->degree != next->degree) ||
           (next->sibling != NULL && next->sibling->degree == curr->degree)) {

            prev = curr;
            curr = next;
        }

        else {
            if(curr->key <= next->key) {
                curr->sibling = next->sibling;
                linkTrees(next, curr);
            }
            else {
                if(prev == NULL)
                    head = next;
                else
                    prev->sibling = next;

                linkTrees(curr, next);
                curr = next;
            }
        }

        next = curr->sibling;
    }

    return head;
}

/* Display heap roots */
void display(Node* h) {
    while(h) {
        printf("%d ", h->key);
        h = h->sibling;
    }
    printf("\n");
}

int main() {

    Node* h1 = newNode(10);
    h1->sibling = newNode(30);

    Node* h2 = newNode(5);
    h2->sibling = newNode(20);

    Node* result = unionHeap(h1, h2);

    printf("Roots after union: ");
    display(result);

    return 0;
}
