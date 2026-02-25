// File Name: InterpolationSearch.java

import java.util.Scanner;

class InterpolationSearch {

    static int interpolationSearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high && key >= arr[low] && key <= arr[high]) {

            if (arr[high] == arr[low])
                break;

            int pos = low + ((key - arr[low]) * (high - low))
                      / (arr[high] - arr[low]);

            if (arr[pos] == key)
                return pos;

            if (arr[pos] < key)
                low = pos + 1;
            else
                high = pos - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        int result = interpolationSearch(arr, key);

        if (result != -1)
            System.out.println("Element found at index " + result);
        else
            System.out.println("Element not found");

        sc.close();
    }
}
