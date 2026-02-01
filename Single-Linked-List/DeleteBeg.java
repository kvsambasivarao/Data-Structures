// File Name: DeleteBeg.java
// Program to delete the first node of a singly linked list

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteBeg {
    static Node head = null;

    // Function to delete beginning node
    static void delete_beg() {
        if (head == null) {
            System.out.println("List is empty. Deletion not possible.");
            return;
        }
        head = head.next;
        System.out.println("First node deleted successfully.");
    }

    public static void main(String[] args) {
        delete_beg();
    }
}
