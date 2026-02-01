// File Name: DoublyLinkedListCreateNode.java
// Program to create a node in a doubly linked list

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

public class DoublyLinkedListCreateNode {

    // Function to create a new node
    static Node createNode(int value) {
        return new Node(value);
    }

    public static void main(String[] args) {
        Node node1 = createNode(10);
    }
}
