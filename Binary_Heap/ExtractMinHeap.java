// File: ExtractMinHeap.java

class ExtractMinHeap {

    int[] heap = new int[100];
    int size = 0;

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

    void insert(int value)
    {
        size++;
        int i = size;
        heap[i] = value;

        while(i > 1 && heap[i] < heap[i/2])
        {
            swap(i, i/2);
            i = i/2;
        }
    }

    int extractMin()
    {
        int min = heap[1];

        heap[1] = heap[size];
        size--;

        minHeapify(1);

        return min;
    }

    void printHeap()
    {
        for(int i = 1; i <= size; i++)
            System.out.print(heap[i] + " ");

        System.out.println();
    }

    public static void main(String[] args)
    {
        ExtractMinHeap h = new ExtractMinHeap();

        h.insert(20);
        h.insert(15);
        h.insert(30);
        h.insert(5);
        h.insert(10);

        System.out.println("Min Heap before extraction:");
        h.printHeap();

        System.out.println("Extracted Min element: " + h.extractMin());

        System.out.println("Heap after extraction:");
        h.printHeap();
    }
}
