// File Name: DeleteEnd.java
// Program to delete the last node of a singly linked list

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteEnd {
    static Node head = null;

    // Function to delete the last node
    static void delete_end() {
        if (head == null) {
            System.out.println("List is empty. Deletion not possible.");
            return;
        }

        // If only one node exists
        if (head.next == null) {
            head = null;
            System.out.println("Last node deleted successfully.");
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        System.out.println("Last node deleted successfully.");
    }

    public static void main(String[] args) {
        delete_end();
    }
}
