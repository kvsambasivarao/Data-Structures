// File: FibonacciExtractMin.java
// Program: Illustrate extracting the minimum key from a Fibonacci Heap

class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        left = right = this;
    }
}

public class FibonacciExtractMin {

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

    static void extractMin()
    {
        if (min == null)
        {
            System.out.println("Heap is empty");
            return;
        }

        Node temp = min;
        System.out.println("Extracted minimum key: " + temp.key);

        if (temp.right == temp)
            min = null;
        else
        {
            temp.left.right = temp.right;
            temp.right.left = temp.left;
            min = temp.right;
        }
    }

    static void display()
    {
        if (min == null)
        {
            System.out.println("Heap is empty");
            return;
        }

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
        insert(10);
        insert(3);
        insert(15);
        insert(6);

        display();

        extractMin();

        display();
    }
}
