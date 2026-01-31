import java.util.Scanner;

// Definition of Node
class Node {
    int data;
    Node next;

    // Constructor to create a node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CreateNode {

    // Method to create a new node
    public static Node createNode() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data for the node: ");
        int value = sc.nextInt();

        Node newNode = new Node(value);
        return newNode;
    }
}
