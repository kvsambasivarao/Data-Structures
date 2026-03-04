/* File: increase_key_min_heap.c */

#include <stdio.h>

#define MAX 100

int heap[MAX];
int size = 0;

/* Swap function */
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = *a;
}

/* Min Heapify function */
void minHeapify(int i)
{
    int smallest = i;
    int left = 2 * i;
    int right = 2 * i + 1;

    if(left <= size && heap[left] < heap[smallest])
        smallest = left;

    if(right <= size && heap[right] < heap[smallest])
        smallest = right;

    if(smallest != i)
    {
        swap(&heap[i], &heap[smallest]);
        minHeapify(smallest);
    }
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

/* Increase Key operation */
void increaseKey(int i, int newValue)
{
    if(newValue < heap[i])
    {
        printf("New value is smaller than current value\n");
        return;
    }

    heap[i] = newValue;

    minHeapify(i);
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
    insert(10);
    insert(20);
    insert(15);
    insert(25);
    insert(30);

    printf("Heap before Increase-Key:\n");
    printHeap();

    increaseKey(1, 35);

    printf("Heap after Increase-Key:\n");
    printHeap();

    return 0;
}
