// File: DeleteKeyBinomialHeap.java

class Node {

    int key;
    Node parent, child, sibling;

    Node(int key){
        this.key = key;
        parent = child = sibling = null;
    }
}

public class DeleteKeyBinomialHeap {

    static void swap(Node a, Node b){
        int temp = a.key;
        a.key = b.key;
        b.key = temp;
    }

    static void decreaseKey(Node node, int newKey){

        node.key = newKey;
        Node parent = node.parent;

        while(parent != null && node.key < parent.key){
            swap(node, parent);
            node = parent;
            parent = node.parent;
        }
    }

    static Node extractMin(Node heap){

        Node min = heap;
        Node prevMin = null;
        Node prev = null;
        Node curr = heap;

        while(curr != null){

            if(curr.key < min.key){
                min = curr;
                prevMin = prev;
            }

            prev = curr;
            curr = curr.sibling;
        }

        if(prevMin != null)
            prevMin.sibling = min.sibling;
        else
            heap = min.sibling;

        System.out.println("Deleted key: " + min.key);

        return heap;
    }

    static Node deleteKey(Node heap, Node node){

        decreaseKey(node, Integer.MIN_VALUE);
        heap = extractMin(heap);

        return heap;
    }

    public static void main(String[] args){

        Node root = new Node(10);
        Node c1 = new Node(20);
        Node c2 = new Node(30);

        root.child = c1;
        c1.sibling = c2;

        c1.parent = root;
        c2.parent = root;

        Node heap = root;

        heap = deleteKey(heap, c1);
    }
}
