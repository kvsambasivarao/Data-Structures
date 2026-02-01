// File Name: DeletePos.java
// Program to delete a node at a given position in a singly linked list

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeletePos {
    static Node head = null;

    // Function to delete node at given position
    static void delete_pos(int pos) {
        if (head == null) {
            System.out.println("List is empty. Deletion not possible.");
            return;
        }

        // If position is 1
        if (pos == 1) {
            head = head.next;
            System.out.println("Node at position " + pos + " deleted successfully.");
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
            if (temp == null || temp.next == null) {
                System.out.println("Invalid position.");
                return;
            }
        }

        temp.next = temp.next.next;
        System.out.println("Node at position " + pos + " deleted successfully.");
    }

    public static void main(String[] args) {
        delete_pos(3);   // example position
    }
}
