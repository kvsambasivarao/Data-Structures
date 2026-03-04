// File: MaxBinaryHeapInsert.java

class MaxBinaryHeapInsert {

    int[] heap = new int[100];
    int size = 0;

    void insert(int value) {
        size++;
        int i = size;

        heap[i] = value;

        while (i > 1 && heap[i] > heap[i / 2]) {
            int temp = heap[i];
            heap[i] = heap[i / 2];
            heap[i / 2] = temp;

            i = i / 2;
        }
    }

    void printHeap() {
        for (int i = 1; i <= size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        MaxBinaryHeapInsert h = new MaxBinaryHeapInsert();

        h.insert(20);
        h.insert(15);
        h.insert(30);
        h.insert(40);
        h.insert(10);

        System.out.println("Max Heap Elements:");
        h.printHeap();
    }
}
