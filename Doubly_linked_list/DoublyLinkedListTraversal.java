// File Name: DoublyLinkedListTraversal.java
// Program to traverse a doubly linked list left to right and right to left

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

public class DoublyLinkedListTraversal {
    static Node head = null;

    // Traverse left to right
    static void traverseForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        System.out.print("Forward traversal: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Traverse right to left
    static void traverseBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        System.out.print("Backward traversal: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        traverseForward();
        traverseBackward();
    }
}
