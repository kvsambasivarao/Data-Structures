import java.util.Scanner;

// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Singly Linked List class
public class SinglyLinkedList {

    Node head = null;

    // Method to insert at beginning
    void insertBeg() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data for new node: ");
        int value = sc.nextInt();

        Node newNode = new Node(value);

        newNode.next = head;   // Point to current head
        head = newNode;        // Update head
    }
}
