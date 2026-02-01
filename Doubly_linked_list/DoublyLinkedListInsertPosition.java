// File Name: DoublyLinkedListInsertPosition.java
// Program to insert a node at a given position in a doubly linked list

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

public class DoublyLinkedListInsertPosition {
    static Node head = null;

    // Function to insert at a given position (1-based)
    static void insert_pos(int value, int pos) {
        Node newNode = new Node(value);

        // Insert at beginning
        if (pos == 1) {
            newNode.next = head;
            if (head != null)
                head.prev = newNode;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null)
            temp.next.prev = newNode;

        temp.next = newNode;
    }

    public static void main(String[] args) {
        insert_pos(25, 2);   // example
    }
}
