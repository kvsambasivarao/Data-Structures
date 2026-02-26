// File Name: ShellSort.java

class ShellSort {

    void shellSort(int arr[]) {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;

                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
        }
    }

    void printArray(int arr[]) {
        for (int value : arr)
            System.out.print(value + " ");
    }

    public static void main(String args[]) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};

        ShellSort ob = new ShellSort();

        System.out.println("Original Array:");
        ob.printArray(arr);

        ob.shellSort(arr);

        System.out.println("\nSorted Array:");
        ob.printArray(arr);
    }
}
