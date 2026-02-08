#include <stdio.h>
#define MAX 5

int queue[MAX];
int front = -1, rear = -1;

void enqueue(int item)
{
    if (rear == MAX - 1)
    {
        printf("Queue Overflow\n");
        return;
    }

    if (front == -1)
        front = 0;

    queue[++rear] = item;
    printf("Inserted %d\n", item);
}

int main()
{
    enqueue(10);
    enqueue(20);
    enqueue(30);
    return 0;
}
