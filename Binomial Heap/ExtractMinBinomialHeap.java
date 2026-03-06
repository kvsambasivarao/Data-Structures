// File: ExtractMinBinomialHeap.java

class Node {

    int key;
    Node parent, child, sibling;

    Node(int key){
        this.key = key;
        parent = child = sibling = null;
    }
}

public class ExtractMinBinomialHeap {

    static Node findMin(Node head){

        Node min = head;
        Node curr = head;

        while(curr != null){

            if(curr.key < min.key)
                min = curr;

            curr = curr.sibling;
        }

        return min;
    }

    static Node reverse(Node node){

        Node prev = null;
        Node curr = node;

        while(curr != null){

            Node next = curr.sibling;
            curr.sibling = prev;
            curr.parent = null;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    static Node extractMin(Node heap){

        if(heap == null)
            return null;

        Node min = heap;
        Node minPrev = null;
        Node prev = null;
        Node curr = heap;

        while(curr != null){

            if(curr.key < min.key){
                min = curr;
                minPrev = prev;
            }

            prev = curr;
            curr = curr.sibling;
        }

        if(minPrev != null)
            minPrev.sibling = min.sibling;
        else
            heap = min.sibling;

        Node childHeap = reverse(min.child);

        System.out.println("Extracted Min: " + min.key);

        return childHeap;
    }

    public static void main(String[] args){

        Node h1 = new Node(10);
        Node h2 = new Node(5);
        Node h3 = new Node(20);

        h1.sibling = h2;
        h2.sibling = h3;

        Node heap = h1;

        heap = extractMin(heap);
    }
}
