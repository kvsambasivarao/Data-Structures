#include <stdio.h>
#define MAX 5

int queue[MAX] = {10, 20, 30};
int front = 0, rear = 2;

void dequeue()
{
    if (front > rear)
    {
        printf("Queue Underflow\n");
        return;
    }

    printf("Deleted %d\n", queue[front]);
    front++;
}

int main()
{
    dequeue();
    dequeue();
    return 0;
}
