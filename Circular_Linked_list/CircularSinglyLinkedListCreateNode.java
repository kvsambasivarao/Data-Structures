// File Name: CircularSinglyLinkedListCreateNode.java
// Program to create a node in a circular singly linked list

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = this;   // Circular link
    }
}

public class CircularSinglyLinkedListCreateNode {

    // Function to create a new node
    static Node createNode(int value) {
        return new Node(value);
    }

    public static void main(String[] args) {
        Node head = createNode(10);
    }
}
