/* File: extract_max_heap.c */

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

/* Max Heapify function */
void maxHeapify(int i)
{
    int largest = i;
    int left = 2 * i;
    int right = 2 * i + 1;

    if (left <= size && heap[left] > heap[largest])
        largest = left;

    if (right <= size && heap[right] > heap[largest])
        largest = right;

    if (largest != i)
    {
        swap(&heap[i], &heap[largest]);
        maxHeapify(largest);
    }
}

/* Insert element into Max Heap */
void insert(int value)
{
    size++;
    int i = size;
    heap[i] = value;

    while (i > 1 && heap[i] > heap[i/2])
    {
        swap(&heap[i], &heap[i/2]);
        i = i/2;
    }
}

/* Extract Max element */
int extractMax()
{
    int max = heap[1];

    heap[1] = heap[size];
    size--;

    maxHeapify(1);

    return max;
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
    insert(40);
    insert(10);

    printf("Max Heap before extraction:\n");
    printHeap();

    printf("Extracted Max element: %d\n", extractMax());

    printf("Heap after extraction:\n");
    printHeap();

    return 0;
}
