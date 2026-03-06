// File: FindMinBinomialHeap.java

class Node {
    int key;
    Node sibling;

    Node(int key) {
        this.key = key;
        this.sibling = null;
    }
}

public class FindMinBinomialHeap {

    static Node findMin(Node head) {

        if(head == null)
            return null;

        Node minNode = head;
        Node current = head.sibling;

        while(current != null) {

            if(current.key < minNode.key)
                minNode = current;

            current = current.sibling;
        }

        return minNode;
    }

    public static void main(String[] args) {

        Node n1 = new Node(10);
        Node n2 = new Node(5);
        Node n3 = new Node(20);

        n1.sibling = n2;
        n2.sibling = n3;

        Node min = findMin(n1);

        if(min != null)
            System.out.println("Minimum key in Binomial Heap: " + min.key);
    }
}
