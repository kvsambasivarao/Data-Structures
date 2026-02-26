// File Name: MSDRadixSort.java

import java.util.ArrayList;

public class MSDRadixSort {

    static int getMax(int arr[]) {
        int max = arr[0];
        for (int num : arr)
            if (num > max)
                max = num;
        return max;
    }

    static void msdRadixSort(int arr[], int left, int right, int exp) {
        if (left >= right || exp == 0)
            return;

        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < 10; i++)
            buckets[i] = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            int digit = (arr[i] / exp) % 10;
            buckets[digit].add(arr[i]);
        }

        int index = left;
        for (int i = 0; i < 10; i++) {
            for (int num : buckets[i])
                arr[index++] = num;

            if (buckets[i].size() > 1)
                msdRadixSort(arr, index - buckets[i].size(), index - 1, exp / 10);
        }
    }

    static void printArray(int arr[]) {
        for (int num : arr)
            System.out.print(num + " ");
    }

    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};

        int max = getMax(arr);
        int exp = (int)Math.pow(10, (int)Math.log10(max));

        msdRadixSort(arr, 0, arr.length - 1, exp);

        System.out.print("Sorted array: ");
        printArray(arr);
    }
}
