// File Name: SinglyLinkedListTraverseReverse.java
// Program to traverse and display a singly linked list in reverse order

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedListTraverseReverse {
    static Node head = null;

    // Recursive function to traverse in reverse
    static void traverse_reverse(Node temp) {
        if (temp == null)
            return;

        traverse_reverse(temp.next);
        System.out.print(temp.data + " -> ");
    }

    public static void main(String[] args) {
        if (head == null) {
            System.out.println("List is empty.");
        } else {
            System.out.print("Reverse order: ");
            traverse_reverse(head);
            System.out.println("NULL");
        }
    }
}
