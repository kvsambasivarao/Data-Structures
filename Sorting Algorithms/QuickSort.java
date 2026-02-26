// File Name: QuickSort.java

public class QuickSort {

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];   // Last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);   // Left
            quickSort(arr, pi + 1, high);  // Right
        }
    }

    static void printArray(int arr[]) {
        for (int value : arr)
            System.out.print(value + " ");
    }

    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};

        quickSort(arr, 0, arr.length - 1);

        System.out.print("Sorted array: ");
        printArray(arr);
    }
}
