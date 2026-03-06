/* File: insertBinomialHeap.c */

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int key, degree;
    struct Node *parent, *child, *sibling;
} Node;

/* Create a new node */
Node* newNode(int key) {
    Node* temp = (Node*)malloc(sizeof(Node));
    temp->key = key;
    temp->degree = 0;
    temp->parent = temp->child = temp->sibling = NULL;
    return temp;
}

/* Merge root lists */
Node* merge(Node* h1, Node* h2) {

    if(!h1) return h2;
    if(!h2) return h1;

    Node *head = NULL, *tail = NULL;

    if(h1->degree <= h2->degree) {
        head = tail = h1;
        h1 = h1->sibling;
    }
    else {
        head = tail = h2;
        h2 = h2->sibling;
    }

    while(h1 && h2) {

        if(h1->degree <= h2->degree) {
            tail->sibling = h1;
            h1 = h1->sibling;
        }
        else {
            tail->sibling = h2;
            h2 = h2->sibling;
        }

        tail = tail->sibling;
    }

    tail->sibling = (h1) ? h1 : h2;

    return head;
}

/* Link trees */
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

/* Insert operation */
Node* insert(Node* heap, int key) {

    Node* temp = newNode(key);
    return unionHeap(heap, temp);
}

/* Display root list */
void display(Node* heap) {

    while(heap) {
        printf("%d ", heap->key);
        heap = heap->sibling;
    }
    printf("\n");
}

int main() {

    Node* heap = NULL;

    heap = insert(heap, 10);
    heap = insert(heap, 5);
    heap = insert(heap, 20);
    heap = insert(heap, 3);

    printf("Root nodes after insertion: ");
    display(heap);

    return 0;
}
