/* File Name: SinglyLinkedList.java */

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

public class SinglyLinkedList {

    Node head = null;
    Scanner sc = new Scanner(System.in);

    // Insert at beginning
    void insertBeg() {
        System.out.print("Enter data: ");
        int value = sc.nextInt();
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    void insertEnd() {
        System.out.print("Enter data: ");
        int value = sc.nextInt();
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    // Delete from beginning
    void deleteBeg() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Delete from end
    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;

        temp.next = null;
    }

    // Display list
    void display() {
        Node temp = head;
        if (temp == null) {
            System.out.println("List is empty");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
