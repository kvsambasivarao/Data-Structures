// File Name: CircularDoublyLinkedListDeleteOperations.java
// Program to delete a node at beginning, end, and given position
// in a circular doubly linked list

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class CircularDoublyLinkedListDeleteOperations {
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

        Node last = head.prev;
        head = head.next;
        head.prev = last;
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

        Node last = head.prev;
        Node secondLast = last.prev;

        secondLast.next = head;
        head.prev = secondLast;
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

        Node temp = head;
        int i;

        for (i = 1; i < pos && temp.next != head; i++)
            temp = temp.next;

        if (i != pos) {
            System.out.println("Invalid position");
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public static void main(String[] args) {
        deleteBeg();
        deleteEnd();
        deletePos(2);
    }
}
