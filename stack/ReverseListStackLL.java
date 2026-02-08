/* File Name: ReverseListStackLL.java */

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Stack {
    Node top = null;

    void push(int x) {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
    }

    int pop() {
        int x = top.data;
        top = top.next;
        return x;
    }
}

public class ReverseListStackLL {
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
