// File Name: DoublyLinkedListDeleteOperations.java
// Program to delete nodes at beginning, end, and given position in a doubly linked list

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

public class DoublyLinkedListDeleteOperations {
    static Node head = null;

    // Delete at beginning
    static void delete_beg() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        if (head != null)
            head.prev = null;
    }

    // Delete at end
    static void delete_end() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.prev.next = null;
    }

    // Delete at given position
    static void delete_pos(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (pos == 1) {
            delete_beg();
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        if (temp.next != null)
            temp.next.prev = temp.prev;

        temp.prev.next = temp.next;
    }

    public static void main(String[] args) {
        delete_beg();
        delete_end();
        delete_pos(2);
    }
}
