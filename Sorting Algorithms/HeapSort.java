// File Name: HeapSort.java

public class HeapSort {

    static void heapify(int arr[], int n, int i) {
        int largest = i;       
        int left = 2 * i + 1;  
        int right = 2 * i + 2; 

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void heapSort(int arr[]) {
        int n = arr.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extract elements
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    static void printArray(int arr[]) {
        for (int value : arr)
            System.out.print(value + " ");
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        heapSort(arr);

        System.out.print("Sorted array: ");
        printArray(arr);
    }
}
