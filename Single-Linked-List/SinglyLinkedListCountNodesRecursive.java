// File Name: SinglyLinkedListCountNodesRecursive.java
// Program to count the number of nodes in a singly linked list using recursion

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedListCountNodesRecursive {
    static Node head = null;

    // Recursive function to count nodes
    static int count_nodes(Node temp) {
        if (temp == null)
            return 0;
        return 1 + count_nodes(temp.next);
    }

    public static void main(String[] args) {
        System.out.println("Number of nodes = " + count_nodes(head));
    }
}
