// File Name: CircularDoublyLinkedListTraversal.java
// Program to traverse a circular doubly linked list
// forward and backward

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class CircularDoublyLinkedListTraversal {
    static Node head = null;

    // Forward traversal
    static void traverseForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Forward traversal: ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("HEAD");
    }

    // Backward traversal
    static void traverseBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head.prev;  // start from last node
        System.out.print("Backward traversal: ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != head.prev);
        System.out.println("HEAD");
    }

    public static void main(String[] args) {
        traverseForward();
        traverseBackward();
    }
}
