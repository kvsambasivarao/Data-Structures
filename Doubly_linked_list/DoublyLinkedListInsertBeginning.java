// File Name: DoublyLinkedListInsertBeginning.java
// Program to insert a node at the beginning of a doubly linked list

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

public class DoublyLinkedListInsertBeginning {
    static Node head = null;

    // Function to insert at beginning
    static void insert_beg(int value) {
        Node newNode = new Node(value);
        newNode.next = head;

        if (head != null)
            head.prev = newNode;

        head = newNode;
    }

    public static void main(String[] args) {
        insert_beg(10);
    }
}
