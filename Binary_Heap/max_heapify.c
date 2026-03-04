/* File: max_heapify.c */

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

    maxHeapify(1);

    printf("After Heapify:\n");
    printHeap();

    return 0;
}
