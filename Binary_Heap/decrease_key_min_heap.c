/* File: decrease_key_min_heap.c */

#include <stdio.h>

#define MAX 100

int heap[MAX];
int size = 0;

/* Swap function */
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

/* Insert element */
void insert(int value)
{
    size++;
    int i = size;
    heap[i] = value;

    while(i > 1 && heap[i] < heap[i/2])
    {
        swap(&heap[i], &heap[i/2]);
        i = i/2;
    }
}

/* Decrease Key operation */
void decreaseKey(int i, int newValue)
{
    if(newValue > heap[i])
    {
        printf("New value is greater than current value\n");
        return;
    }

    heap[i] = newValue;

    while(i > 1 && heap[i] < heap[i/2])
    {
        swap(&heap[i], &heap[i/2]);
        i = i/2;
    }
}

/* Print heap */
void printHeap()
{
    for(int i = 1; i <= size; i++)
        printf("%d ", heap[i]);

    printf("\n");
}

int main()
{
    insert(20);
    insert(15);
    insert(30);
    insert(25);
    insert(40);

    printf("Heap before Decrease-Key:\n");
    printHeap();

    decreaseKey(4, 10);

    printf("Heap after Decrease-Key:\n");
    printHeap();

    return 0;
}
