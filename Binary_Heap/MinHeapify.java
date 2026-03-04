// File: MinHeapify.java

class MinHeapify {

    int[] heap = {0, 10, 5, 3, 2, 4};
    int size = 5;

    void swap(int a, int b)
    {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    void minHeapify(int i)
    {
        int smallest = i;
        int left = 2*i;
        int right = 2*i + 1;

        if(left <= size && heap[left] < heap[smallest])
            smallest = left;

        if(right <= size && heap[right] < heap[smallest])
            smallest = right;

        if(smallest != i)
        {
            swap(i, smallest);
            minHeapify(smallest);
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
        MinHeapify h = new MinHeapify();

        System.out.println("Before Heapify:");
        h.printHeap();

        h.minHeapify(1);

        System.out.println("After Heapify:");
        h.printHeap();
    }
}
