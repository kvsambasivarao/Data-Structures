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

// Linked List class
public class SinglyLinkedList {

    Node head = null;

    // Method to create list
    void createList(int n) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter data for node " + i + ": ");
            int value = sc.nextInt();

            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = newNode;
            }
        }
    }
}
