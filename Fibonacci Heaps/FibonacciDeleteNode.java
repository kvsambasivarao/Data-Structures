// File: FibonacciDeleteNode.java
// Program: Delete a node in a Fibonacci Heap

class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        left = right = this;
    }
}

public class FibonacciDeleteNode {

    static Node min = null;

    static Node insert(Node min, int key)
    {
        Node n = new Node(key);

        if (min == null)
            return n;

        n.left = min;
        n.right = min.right;
        min.right.left = n;
        min.right = n;

        if (n.key < min.key)
            min = n;

        return min;
    }

    static void decreaseKey(Node x, int newKey)
    {
        x.key = newKey;

        if (x.key < min.key)
            min = x;
    }

    static void extractMin()
    {
        if (min == null)
            return;

        Node temp = min;

        if (temp.right == temp)
            min = null;
        else
        {
            temp.left.right = temp.right;
            temp.right.left = temp.left;
            min = temp.right;
        }

        System.out.println("Deleted node with key " + temp.key);
    }

    static void deleteNode(Node x)
    {
        decreaseKey(x, Integer.MIN_VALUE);
        extractMin();
    }

    public static void main(String[] args)
    {
        Node n1 = new Node(10);
        Node n2 = new Node(20);

        min = insert(min, 10);
        min = insert(min, 20);

        deleteNode(n2);
    }
}
