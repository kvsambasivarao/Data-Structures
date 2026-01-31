/* File Name: InsertAtEnd.java */

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
public class InsertAtEnd {

    Node head = null;

    // Method to insert a node at the end
    void insertEnd() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data for new node: ");
        int value = sc.nextInt();

        Node newNode = new Node(value);

        // If list is empty
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }
}
