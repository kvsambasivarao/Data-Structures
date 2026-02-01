// File Name: CircularSinglyLinkedListDeleteOperations.java
// Program to delete a node at beginning, end, and given position
// in a circular singly linked list

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularSinglyLinkedListDeleteOperations {
    static Node head = null;

    // Delete at beginning
    static void deleteBeg() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node last = head;
        while (last.next != head)
            last = last.next;

        head = head.next;
        last.next = head;
    }

    // Delete at end
    static void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node temp = head, prev = null;
        while (temp.next != head) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = head;
    }

    // Delete at given position (1-based)
    static void deletePos(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos == 1) {
            deleteBeg();
            return;
        }

        Node temp = head, prev = null;
        int i;

        for (i = 1; i < pos && temp.next != head; i++) {
            prev = temp;
            temp = temp.next;
        }

        if (i != pos) {
            System.out.println("Invalid position");
            return;
        }

        prev.next = temp.next;
    }

    public static void main(String[] args) {
        deleteBeg();
        deleteEnd();
        deletePos(2);
    }
}
