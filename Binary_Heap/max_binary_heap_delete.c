/* File: max_binary_heap_delete.c */

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

/* Insert function (for testing heap) */
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

/* Delete max element */
int deleteMax()
{
    int max = heap[1];

    heap[1] = heap[size];
    size--;

    int i = 1;

    while(2*i <= size)
    {
        int largest = i;

        if(heap[2*i] > heap[largest])
            largest = 2*i;

        if(2*i+1 <= size && heap[2*i+1] > heap[largest])
            largest = 2*i+1;

        if(largest != i)
        {
            swap(&heap[i], &heap[largest]);
            i = largest;
        }
        else
            break;
    }

    return max;
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
    insert(40);
    insert(10);

    printf("Heap before deletion:\n");
    printHeap();

    printf("Deleted element: %d\n", deleteMax());

    printf("Heap after deletion:\n");
    printHeap();

    return 0;
}
