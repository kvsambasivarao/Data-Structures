#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *next;
};

struct Node *front = NULL, *rear = NULL;

void enqueue(int item)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = item;
    newNode->next = NULL;

    if (rear == NULL)
    {
        front = rear = newNode;
    }
    else
    {
        rear->next = newNode;
        rear = newNode;
    }
    printf("Inserted %d\n", item);
}

int main()
{
    enqueue(10);
    enqueue(20);
    enqueue(30);
    return 0;
}
