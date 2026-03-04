/* File: decrease_key_max_heap.c */

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

    if(left <= size && heap[left] > heap[largest])
        largest = left;

    if(right <= size && heap[right] > heap[largest])
        largest = right;

    if(largest != i)
    {
        swap(&heap[i], &heap[largest]);
        maxHeapify(largest);
    }
}

/* Insert element */
void insert(int value)
{
    size++;
    int i = size;
    heap[i] = value;

    while(i > 1 && heap[i] > heap[i/2])
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

    maxHeapify(i);
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
    insert(50);
    insert(40);
    insert(45);
    insert(30);
    insert(35);

    printf("Heap before Decrease-Key:\n");
    printHeap();

    decreaseKey(1, 25);

    printf("Heap after Decrease-Key:\n");
    printHeap();

    return 0;
}
