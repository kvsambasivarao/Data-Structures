/* File Name: CircularSinglyLinkedList.java
   Operations:
   1. Insert at beginning
   2. Insert at end
   3. Delete from beginning
   4. Delete from end
   5. Display list
*/

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularSinglyLinkedList {

    Node head = null;
    Scanner sc = new Scanner(System.in);

    // Insert at beginning
    void insertBeg() {
        System.out.print("Enter data: ");
        Node newNode = new Node(sc.nextInt());

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head)
                temp = temp.next;
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    // Insert at end
    void insertEnd() {
        System.out.print("Enter data: ");
        Node newNode = new Node(sc.nextInt());

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Delete from beginning
    void deleteBeg() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head)
                temp = temp.next;
            head = head.next;
            temp.next = head;
        }
    }

    // Delete from end
    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != head)
                temp = temp.next;
            temp.next = head;
        }
    }

    // Display list
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }
}
