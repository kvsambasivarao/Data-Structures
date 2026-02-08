/* File Name: ReverseListStackArray.java */

import java.util.Scanner;

class Stack {
    int[] stack = new int[100];
    int top = -1;

    void push(int x) {
        stack[++top] = x;
    }

    int pop() {
        return stack[top--];
    }
}

public class ReverseListStackArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            s.push(arr[i]);
        }

        for (int i = 0; i < n; i++)
            arr[i] = s.pop();

        System.out.println("Reversed list:");
        for (int x : arr)
            System.out.print(x + " ");

        sc.close();
    }
}
