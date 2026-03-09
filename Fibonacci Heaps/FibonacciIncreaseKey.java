// File: FibonacciIncreaseKey.java
// Program: Increase a key value in a Fibonacci Heap

class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        left = right = this;
    }
}

public class FibonacciIncreaseKey {

    static void increaseKey(Node x, int newKey)
    {
        if (newKey < x.key)
        {
            System.out.println("New key is smaller than current key");
            return;
        }

        x.key = newKey;
        System.out.println("Key increased to " + newKey);
    }

    public static void main(String[] args)
    {
        Node node = new Node(10);

        increaseKey(node, 25);
    }
}
