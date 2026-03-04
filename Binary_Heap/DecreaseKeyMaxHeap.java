// File: DecreaseKeyMaxHeap.java

class DecreaseKeyMaxHeap {

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

    void decreaseKey(int i, int newValue)
    {
        if(newValue > heap[i])
        {
            System.out.println("New value is greater than current value");
            return;
        }

        heap[i] = newValue;

        maxHeapify(i);
    }

    void printHeap()
    {
        for(int i = 1; i <= size; i++)
            System.out.print(heap[i] + " ");

        System.out.println();
    }

    public static void main(String[] args)
    {
        DecreaseKeyMaxHeap h = new DecreaseKeyMaxHeap();

        h.insert(50);
        h.insert(40);
        h.insert(45);
        h.insert(30);
        h.insert(35);

        System.out.println("Heap before Decrease-Key:");
        h.printHeap();

        h.decreaseKey(1, 25);

        System.out.println("Heap after Decrease-Key:");
        h.printHeap();
    }
}
