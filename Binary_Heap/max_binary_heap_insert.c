/* File: max_binary_heap_insert.c */

#include <stdio.h>

#define MAX 100

int heap[MAX];
int size = 0;

/* Function to swap two numbers */
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

/* Insert element into Max Heap */
void insert(int value)
{
    size++;
    int i = size;

    heap[i] = value;

    /* Heapify up */
    while (i > 1 && heap[i] > heap[i / 2])
    {
        swap(&heap[i], &heap[i / 2]);
        i = i / 2;
    }
}

/* Display Heap */
void printHeap()
{
    for (int i = 1; i <= size; i++)
        printf("%d ", heap[i]);
    printf("\n");
}

int main()
{
    insert(20);
    insert(15);
    insert(30);
    insert(40);
    insert(10);

    printf("Max Heap Elements:\n");
    printHeap();

    return 0;
}
