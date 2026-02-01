// File Name: DoublyLinkedListInsertEnd.java
// Program to insert a node at the end of a doubly linked list

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

public class DoublyLinkedListInsertEnd {
    static Node head = null;

    // Function to insert at end
    static void insert_end(int value) {
        Node newNode = new Node(value);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    public static void main(String[] args) {
        insert_end(10);
    }
}
