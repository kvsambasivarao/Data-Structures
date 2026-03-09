// File: FibonacciFindMin.java
// Program: Find the minimum key in a Fibonacci Heap

class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        left = right = this;
    }
}

public class FibonacciFindMin {

    static Node min = null;

    static void insert(int key) {

        Node n = new Node(key);

        if (min == null)
            min = n;
        else {

            n.left = min;
            n.right = min.right;
            min.right.left = n;
            min.right = n;

            if (n.key < min.key)
                min = n;
        }
    }

    static void findMin() {

        if (min == null)
            System.out.println("Heap is empty");
        else
            System.out.println("Minimum key in Fibonacci Heap: " + min.key);
    }

    public static void main(String[] args) {

        insert(10);
        insert(3);
        insert(15);
        insert(6);

        findMin();
    }
}
