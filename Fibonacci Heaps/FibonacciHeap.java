// File: FibonacciHeap.java
// Program: Create a Fibonacci Heap and insert nodes

class Node {
    int key, degree;
    Node parent, child, left, right;

    Node(int key) {
        this.key = key;
        this.degree = 0;
        parent = child = null;
        left = right = this;
    }
}

public class FibonacciHeap {

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

        System.out.println("Inserted node " + key);
    }

    static void display() {

        Node temp = min;

        if (temp == null)
            return;

        System.out.print("Root List: ");

        do {
            System.out.print(temp.key + " ");
            temp = temp.right;
        } while (temp != min);

        System.out.println();
    }

    public static void main(String[] args) {

        insert(10);
        insert(3);
        insert(15);
        insert(6);

        display();
    }
}
