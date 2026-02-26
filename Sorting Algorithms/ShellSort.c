/* File Name: ShellSort.c */

#include <stdio.h>

void shellSort(int arr[], int n) {
    int gap, i, j, temp;

    // Start with a big gap, then reduce the gap
    for (gap = n / 2; gap > 0; gap /= 2) {

        // Perform gapped insertion sort
        for (i = gap; i < n; i++) {
            temp = arr[i];

            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                arr[j] = arr[j - gap];
            }

            arr[j] = temp;
        }
    }
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
}

int main() {
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Original Array:\n");
    printArray(arr, n);

    shellSort(arr, n);

    printf("\nSorted Array:\n");
    printArray(arr, n);

    return 0;
}
