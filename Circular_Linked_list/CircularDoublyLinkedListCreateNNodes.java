// File Name: CircularDoublyLinkedListCreateNNodes.java
// Program to create a circular doubly linked list with n nodes

import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class CircularDoublyLinkedListCreateNNodes {
    static Node head = null;

    // Function to create circular doubly linked list with n nodes
    static void createList(int n) {
        Scanner sc = new Scanner(System.in);
        Node temp = null;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter data for node " + i + ": ");
            int value = sc.nextInt();
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                head.next = head;
                head.prev = head;
                temp = head;
            } else {
                newNode.next = head;
                newNode.prev = temp;
                temp.next = newNode;
                head.prev = newNode;
                temp = newNode;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        createList(n);
    }
}
