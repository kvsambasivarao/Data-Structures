#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *next;
};

struct Node *front = NULL;

void dequeue()
{
    if (front == NULL)
    {
        printf("Queue Underflow\n");
        return;
    }

    struct Node *temp = front;
    printf("Deleted %d\n", temp->data);
    front = front->next;
    free(temp);
}

int main()
{
    // Pre-created queue: 10 -> 20 -> 30
    struct Node *n1 = (struct Node *)malloc(sizeof(struct Node));
    struct Node *n2 = (struct Node *)malloc(sizeof(struct Node));
    struct Node *n3 = (struct Node *)malloc(sizeof(struct Node));

    n1->data = 10; n1->next = n2;
    n2->data = 20; n2->next = n3;
    n3->data = 30; n3->next = NULL;

    front = n1;

    dequeue();
    dequeue();
    return 0;
}
