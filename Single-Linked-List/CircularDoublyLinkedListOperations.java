/* File Name: CircularDoublyLinkedList.java
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
    Node prev, next;

    Node(int data) {
        this.data = data;
    }
}

public class CircularDoublyLinkedList {

    Node head = null;
    Scanner sc = new Scanner(System.in);

    // Insert at beginning
    void insertBeg() {
        System.out.print("Enter data: ");
        Node newNode = new Node(sc.nextInt());

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            last.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at end
    void insertEnd() {
        System.out.print("Enter data: ");
        Node newNode = new Node(sc.nextInt());

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            last.next = newNode;
            head.prev = newNode;
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
            Node last = head.prev;
            head = head.next;
            head.prev = last;
            last.next = head;
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
            Node last = head.prev;
            Node prevNode = last.prev;
            prevNode.next = head;
            head.prev = prevNode;
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
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }
}
