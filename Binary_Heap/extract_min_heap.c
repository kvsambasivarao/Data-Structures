/* File: extract_min_heap.c */

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

/* Min Heapify function */
void minHeapify(int i)
{
    int smallest = i;
    int left = 2 * i;
    int right = 2 * i + 1;

    if (left <= size && heap[left] < heap[smallest])
        smallest = left;

    if (right <= size && heap[right] < heap[smallest])
        smallest = right;

    if (smallest != i)
    {
        swap(&heap[i], &heap[smallest]);
        minHeapify(smallest);
    }
}

/* Insert element into Min Heap */
void insert(int value)
{
    size++;
    int i = size;
    heap[i] = value;

    while (i > 1 && heap[i] < heap[i/2])
    {
        swap(&heap[i], &heap[i/2]);
        i = i/2;
    }
}

/* Extract Min element */
int extractMin()
{
    int min = heap[1];

    heap[1] = heap[size];
    size--;

    minHeapify(1);

    return min;
}

/* Display heap */
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

    printf("Min Heap before extraction:\n");
    printHeap();

    printf("Extracted Min element: %d\n", extractMin());

    printf("Heap after extraction:\n");
    printHeap();

    return 0;
}
