// File: MinBinaryHeapDelete.java

class MinBinaryHeapDelete {

    int[] heap = new int[100];
    int size = 0;

    void insert(int value)
    {
        size++;
        int i = size;
        heap[i] = value;

        while(i > 1 && heap[i] < heap[i/2])
        {
            int temp = heap[i];
            heap[i] = heap[i/2];
            heap[i/2] = temp;
            i = i/2;
        }
    }

    int deleteMin()
    {
        int min = heap[1];

        heap[1] = heap[size];
        size--;

        int i = 1;

        while(2*i <= size)
        {
            int smallest = i;

            if(heap[2*i] < heap[smallest])
                smallest = 2*i;

            if(2*i+1 <= size && heap[2*i+1] < heap[smallest])
                smallest = 2*i+1;

            if(smallest != i)
            {
                int temp = heap[i];
                heap[i] = heap[smallest];
                heap[smallest] = temp;

                i = smallest;
            }
            else
                break;
        }

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
        MinBinaryHeapDelete h = new MinBinaryHeapDelete();

        h.insert(20);
        h.insert(15);
        h.insert(30);
        h.insert(5);
        h.insert(10);

        System.out.println("Heap before deletion:");
        h.printHeap();

        System.out.println("Deleted element: " + h.deleteMin());

        System.out.println("Heap after deletion:");
        h.printHeap();
    }
}
