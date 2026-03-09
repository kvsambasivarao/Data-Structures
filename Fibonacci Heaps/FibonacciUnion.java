// File: FibonacciUnion.java
// Program: Illustrate union of two Fibonacci Heaps

class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        left = right = this;
    }
}

public class FibonacciUnion {

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

    static Node unionHeap(Node min1, Node min2)
    {
        if (min1 == null) return min2;
        if (min2 == null) return min1;

        Node temp = min1.right;
        min1.right = min2.right;
        min2.right.left = min1;
        min2.right = temp;
        temp.left = min2;

        if (min2.key < min1.key)
            return min2;
        else
            return min1;
    }

    static void display(Node min)
    {
        Node temp = min;

        System.out.print("Heap nodes: ");

        do {
            System.out.print(temp.key + " ");
            temp = temp.right;
        } while (temp != min);

        System.out.println();
    }

    public static void main(String[] args)
    {
        Node H1 = null;
        Node H2 = null;

        H1 = insert(H1, 10);
        H1 = insert(H1, 3);
        H1 = insert(H1, 15);

        H2 = insert(H2, 7);
        H2 = insert(H2, 2);
        H2 = insert(H2, 18);

        Node H = unionHeap(H1, H2);

        display(H);
    }
}
