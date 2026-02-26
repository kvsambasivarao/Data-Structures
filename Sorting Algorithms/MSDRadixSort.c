// File Name: MSDRadixSort.c

#include <stdio.h>
#include <math.h>

#define BASE 10

int getMax(int arr[], int n) {
    int max = arr[0];
    for (int i = 1; i < n; i++)
        if (arr[i] > max)
            max = arr[i];
    return max;
}

void msdRadixSort(int arr[], int left, int right, int exp) {
    if (left >= right || exp == 0)
        return;

    int i, bucket[BASE][right - left + 1];
    int count[BASE] = {0};

    // Place elements into buckets
    for (i = left; i <= right; i++) {
        int digit = (arr[i] / exp) % 10;
        bucket[digit][count[digit]++] = arr[i];
    }

    // Copy back and recursively sort buckets
    int index = left;
    for (i = 0; i < BASE; i++) {
        for (int j = 0; j < count[i]; j++)
            arr[index++] = bucket[i][j];

        if (count[i] > 1)
            msdRadixSort(arr, index - count[i], index - 1, exp / 10);
    }
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
}

int main() {
    int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
    int n = sizeof(arr) / sizeof(arr[0]);

    int max = getMax(arr, n);
    int exp = pow(10, (int)log10(max));

    msdRadixSort(arr, 0, n - 1, exp);

    printf("Sorted array: ");
    printArray(arr, n);

    return 0;
}
