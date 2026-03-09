// File: FibonacciMarking.java
// Program: Demonstrate node marking and cascading cut in Fibonacci Heap

class Node
{
    int key;
    boolean mark;
    Node parent;

    Node(int key)
    {
        this.key = key;
        this.mark = false;
        this.parent = null;
    }
}

public class FibonacciMarking
{

    static void cut(Node child, Node parent)
    {
        System.out.println("Cut node " + child.key + " from parent " + parent.key);

        child.parent = null;

        if(!parent.mark)
        {
            parent.mark = true;
            System.out.println("Node " + parent.key + " marked (first child cut)");
        }
        else
        {
            System.out.println("Node " + parent.key + " cut due to second child loss (cascading cut)");
        }
    }

    public static void main(String[] args)
    {
        Node parent = new Node(10);
        Node child1 = new Node(20);
        Node child2 = new Node(30);

        child1.parent = parent;
        child2.parent = parent;

        cut(child1, parent);
        cut(child2, parent);
    }
}
