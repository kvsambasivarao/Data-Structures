/* 
 * File Name: update_array_elements.c
 * Description: Program to demonstrate updating elements in an array
 * Language: C
 */

#include <stdio.h>

int main() {
    // Declare and initialize an array
    int arr[5] = {1, 2, 3, 4, 5};

    // Print the original array
    printf("Original array: ");
    for (int i = 0; i < 5; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    // Calculate the sum of array elements
    int sum = 0;
    for (int i = 0; i < 5; i++) {
        sum += arr[i];
    }

    // Print the sum
    printf("Sum of array elements: %d\n", sum);

    // Update each element by doubling its value
    for (int i = 0; i < 5; i++) {
        arr[i] = arr[i] * 2;
    }

    // Print the updated array
    printf("Updated array: ");
    for (int i = 0; i < 5; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
