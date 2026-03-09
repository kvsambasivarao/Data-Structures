// File: FibonacciDecreaseKey.java
// Program: Decrease a key value in a Fibonacci Heap

class Node {
    int key;
    Node parent, left, right;

    Node(int key) {
        this.key = key;
        parent = null;
        left = right = this;
    }
}

public class FibonacciDecreaseKey {

    static Node min = null;

    static void insert(int key)
    {
        Node n = new Node(key);

        if (min == null)
            min = n;
        else
        {
            n.left = min;
            n.right = min.right;
            min.right.left = n;
            min.right = n;

            if (n.key < min.key)
                min = n;
        }
    }

    static void decreaseKey(Node x, int newKey)
    {
        if (newKey > x.key)
        {
            System.out.println("New key is greater than current key");
            return;
        }

        x.key = newKey;

        if (x.key < min.key)
            min = x;

        System.out.println("Key decreased to " + newKey);
    }

    public static void main(String[] args)
    {
        Node n1 = new Node(10);
        Node n2 = new Node(20);

        insert(n1.key);
        insert(n2.key);

        decreaseKey(n2, 5);

        System.out.println("Current minimum key: " + min.key);
    }
}
