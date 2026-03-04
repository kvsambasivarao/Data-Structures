/* File: min_binary_heap_insert.c */

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

/* Insert into Min Heap */
void insert(int value)
{
    size++;
    int i = size;

    heap[i] = value;

    /* Heapify Up */
    while (i > 1 && heap[i] < heap[i/2])
    {
        swap(&heap[i], &heap[i/2]);
        i = i/2;
    }
}

/* Print Heap */
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
    insert(5);
    insert(10);

    printf("Min Heap Elements:\n");
    printHeap();

    return 0;
}
