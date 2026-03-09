// File: FibonacciCascadingCut.java
// Program: Demonstrate Cascading Cut in Fibonacci Heap

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

public class FibonacciCascadingCut
{

    static void cascadingCut(Node y)
    {
        Node z = y.parent;

        if (z != null)
        {
            if (!y.mark)
            {
                y.mark = true;
                System.out.println("Node " + y.key + " marked");
            }
            else
            {
                System.out.println("Cascading cut: node " + y.key +
                                   " cut from parent " + z.key);
                y.parent = null;
                cascadingCut(z);
            }
        }
    }

    public static void main(String[] args)
    {
        Node parent = new Node(10);
        Node child = new Node(20);

        child.parent = parent;

        cascadingCut(child);
        cascadingCut(child);
    }
}
