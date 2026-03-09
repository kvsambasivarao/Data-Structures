// File: FibonacciInsert.java
// Program: Insert a node into a Fibonacci Heap

class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        left = right = this;
    }
}

public class FibonacciInsert {

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

        System.out.println("Inserted node " + key);
    }

    public static void main(String[] args)
    {
        insert(10);
        insert(4);
        insert(15);
        insert(2);

        System.out.println("Current minimum key: " + min.key);
    }
}
