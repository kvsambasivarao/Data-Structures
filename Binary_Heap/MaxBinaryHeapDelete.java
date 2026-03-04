// File: MaxBinaryHeapDelete.java

class MaxBinaryHeapDelete {

    int[] heap = new int[100];
    int size = 0;

    void insert(int value)
    {
        size++;
        int i = size;
        heap[i] = value;

        while(i > 1 && heap[i] > heap[i/2])
        {
            int temp = heap[i];
            heap[i] = heap[i/2];
            heap[i/2] = temp;
            i = i/2;
        }
    }

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
                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;

                i = largest;
            }
            else
                break;
        }

        return max;
    }

    void printHeap()
    {
        for(int i=1;i<=size;i++)
            System.out.print(heap[i]+" ");

        System.out.println();
    }

    public static void main(String[] args)
    {
        MaxBinaryHeapDelete h = new MaxBinaryHeapDelete();

        h.insert(20);
        h.insert(15);
        h.insert(30);
        h.insert(40);
        h.insert(10);

        System.out.println("Heap before deletion:");
        h.printHeap();

        System.out.println("Deleted element: " + h.deleteMax());

        System.out.println("Heap after deletion:");
        h.printHeap();
    }
}
