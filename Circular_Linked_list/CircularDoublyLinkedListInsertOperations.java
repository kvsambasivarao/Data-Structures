// File Name: CircularDoublyLinkedListInsertOperations.java
// Program to insert a node at beginning, end, and given position
// in a circular doubly linked list

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class CircularDoublyLinkedListInsertOperations {
    static Node head = null;

    // Insert at beginning
    static void insertBeg(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
            return;
        }

        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;
        last.next = newNode;
        head.prev = newNode;
        head = newNode;
    }

    // Insert at end
    static void insertEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
            return;
        }

        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;
        last.next = newNode;
        head.prev = newNode;
    }

    // Insert at given position (1-based)
    static void insertPos(int value, int pos) {
        if (head == null || pos == 1) {
            insertBeg(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        Node newNode = new Node(value);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    public static void main(String[] args) {
        insertBeg(10);
        insertEnd(30);
        insertPos(20, 2);
    }
}
