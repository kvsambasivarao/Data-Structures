/* File: min_heapify.c */

#include <stdio.h>

#define MAX 100

int heap[MAX];
int size;

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

/* Print Heap */
void printHeap()
{
    for(int i = 1; i <= size; i++)
        printf("%d ", heap[i]);

    printf("\n");
}

int main()
{
    int i;

    /* Example array (not a heap initially) */
    int arr[] = {0, 10, 5, 3, 2, 4};

    size = 5;

    for(i = 1; i <= size; i++)
        heap[i] = arr[i];

    printf("Before Heapify:\n");
    printHeap();

    minHeapify(1);

    printf("After Heapify:\n");
    printHeap();

    return 0;
}
