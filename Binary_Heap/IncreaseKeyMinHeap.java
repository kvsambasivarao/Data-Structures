// File: IncreaseKeyMinHeap.java

class IncreaseKeyMinHeap {

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

    void increaseKey(int i, int newValue)
    {
        if(newValue < heap[i])
        {
            System.out.println("New value is smaller than current value");
            return;
        }

        heap[i] = newValue;

        minHeapify(i);
    }

    void printHeap()
    {
        for(int i = 1; i <= size; i++)
            System.out.print(heap[i] + " ");

        System.out.println();
    }

    public static void main(String[] args)
    {
        IncreaseKeyMinHeap h = new IncreaseKeyMinHeap();

        h.insert(10);
        h.insert(20);
        h.insert(15);
        h.insert(25);
        h.insert(30);

        System.out.println("Heap before Increase-Key:");
        h.printHeap();

        h.increaseKey(1, 35);

        System.out.println("Heap after Increase-Key:");
        h.printHeap();
    }
}
