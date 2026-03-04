// File: MaxHeapify.java

class MaxHeapify {

    int[] heap = {0, 10, 5, 3, 2, 4};
    int size = 5;

    void swap(int a, int b)
    {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    void maxHeapify(int i)
    {
        int largest = i;
        int left = 2*i;
        int right = 2*i + 1;

        if(left <= size && heap[left] > heap[largest])
            largest = left;

        if(right <= size && heap[right] > heap[largest])
            largest = right;

        if(largest != i)
        {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    void printHeap()
    {
        for(int i=1;i<=size;i++)
            System.out.print(heap[i]+" ");

        System.out.println();
    }

    public static void main(String[] args)
    {
        MaxHeapify h = new MaxHeapify();

        System.out.println("Before Heapify:");
        h.printHeap();

        h.maxHeapify(1);

        System.out.println("After Heapify:");
        h.printHeap();
    }
}
