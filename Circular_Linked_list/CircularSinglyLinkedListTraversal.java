// File Name: CircularSinglyLinkedListTraversal.java
// Program to traverse a circular singly linked list
// left to right and right to left (using recursion)

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularSinglyLinkedListTraversal {
    static Node head = null;

    // Left to Right traversal
    static void traverseForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Left to Right: ");
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("HEAD");
    }

    // Recursive helper
    static void traverseReverseUtil(Node current) {
        if (current.next != head)
            traverseReverseUtil(current.next);

        System.out.print(current.data + " -> ");
    }

    // Right to Left traversal
    static void traverseBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("Right to Left: ");
        traverseReverseUtil(head);
        System.out.println("HEAD");
    }

    public static void main(String[] args) {
        traverseForward();
        traverseBackward();
    }
}
