// File: IncreaseKeyMaxHeap.java

class IncreaseKeyMaxHeap {

    int[] heap = new int[100];
    int size = 0;

    void swap(int a, int b)
    {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
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

    void increaseKey(int i, int newValue)
    {
        if(newValue < heap[i])
        {
            System.out.println("New value is smaller than current value");
            return;
        }

        heap[i] = newValue;

        while(i > 1 && heap[i] > heap[i/2])
        {
            swap(i, i/2);
            i = i/2;
        }
    }

    void printHeap()
    {
        for(int i = 1; i <= size; i++)
            System.out.print(heap[i] + " ");

        System.out.println();
    }

    public static void main(String[] args)
    {
        IncreaseKeyMaxHeap h = new IncreaseKeyMaxHeap();

        h.insert(20);
        h.insert(15);
        h.insert(30);
        h.insert(10);
        h.insert(40);

        System.out.println("Heap before Increase-Key:");
        h.printHeap();

        h.increaseKey(4, 35);

        System.out.println("Heap after Increase-Key:");
        h.printHeap();
    }
}
