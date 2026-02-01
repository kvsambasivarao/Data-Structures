// File Name: CircularSinglyLinkedListInsertOperations.java
// Program to insert a node at beginning, end, and given position
// in a circular singly linked list

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularSinglyLinkedListInsertOperations {
    static Node head = null;

    // Insert at beginning
    static void insertBeg(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head)
            temp = temp.next;

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // Insert at end
    static void insertEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    // Insert at given position (1-based)
    static void insertPos(int value, int pos) {
        if (head == null || pos == 1) {
            insertBeg(value);
            return;
        }

        Node newNode = new Node(value);
        Node temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void main(String[] args) {
        insertBeg(10);
        insertEnd(20);
        insertPos(15, 2);
    }
}
