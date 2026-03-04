// File: ExtractMaxHeap.java

class ExtractMaxHeap {

    int[] heap = new int[100];
    int size = 0;

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

    void insert(int value)
    {
        size++;
        int i = size;
        heap[i] = value;

        while(i > 1 && heap[i] > heap[i/2])
        {
            swap(i, i/2);
            i = i/2;
        }
    }

    int extractMax()
    {
        int max = heap[1];

        heap[1] = heap[size];
        size--;

        maxHeapify(1);

        return max;
    }

    void printHeap()
    {
        for(int i = 1; i <= size; i++)
            System.out.print(heap[i] + " ");

        System.out.println();
    }

    public static void main(String[] args)
    {
        ExtractMaxHeap h = new ExtractMaxHeap();

        h.insert(20);
        h.insert(15);
        h.insert(30);
        h.insert(40);
        h.insert(10);

        System.out.println("Max Heap before extraction:");
        h.printHeap();

        System.out.println("Extracted Max element: " + h.extractMax());

        System.out.println("Heap after extraction:");
        h.printHeap();
    }
}
