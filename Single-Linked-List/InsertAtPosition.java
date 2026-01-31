/* File Name: InsertAtPosition.java */

import java.util.Scanner;

// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Singly Linked List class
public class InsertAtPosition {

    Node head = null;

    // Method to insert at a given position
    void insertPos(int pos) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data for new node: ");
        int value = sc.nextInt();

        Node newNode = new Node(value);

        // Insert at beginning
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
}
