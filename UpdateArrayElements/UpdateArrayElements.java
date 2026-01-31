/*
 * File Name: UpdateArrayElements.java
 * Description: Program to demonstrate updating elements in an array
 * Language: Java
 */

public class UpdateArrayElements {

    public static void main(String[] args) {

        // Declare and initialize an array
        int[] arr = {1, 2, 3, 4, 5};

        // Print the original array
        System.out.print("Original array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Calculate the sum of array elements
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // Print the sum
        System.out.println("Sum of array elements: " + sum);

        // Update each element by doubling its value
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;
        }

        // Print the updated array
        System.out.print("Updated array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
