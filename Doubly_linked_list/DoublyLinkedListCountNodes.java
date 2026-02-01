// File Name: DoublyLinkedListCountNodes.java
// Program to count the number of nodes in a doubly linked list

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

public class DoublyLinkedListCountNodes {
    static Node head = null;

    // Function to count nodes
    static int count_nodes() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Number of nodes = " + count_nodes());
    }
}
