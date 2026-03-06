// File: IncreaseKeyBinomialHeap.java

class Node {

    int key;
    Node parent, child, sibling;

    Node(int key){
        this.key = key;
        parent = child = sibling = null;
    }
}

public class IncreaseKeyBinomialHeap {

    static void swap(Node a, Node b){
        int temp = a.key;
        a.key = b.key;
        b.key = temp;
    }

    static void heapifyDown(Node node){

        while(node.child != null){

            Node minChild = node.child;
            Node curr = minChild.sibling;

            while(curr != null){
                if(curr.key < minChild.key)
                    minChild = curr;
                curr = curr.sibling;
            }

            if(node.key <= minChild.key)
                break;

            swap(node, minChild);
            node = minChild;
        }
    }

    static void increaseKey(Node node, int newKey){

        if(newKey < node.key){
            System.out.println("New key is smaller than current key");
            return;
        }

        node.key = newKey;
        heapifyDown(node);
    }

    public static void main(String[] args){

        Node root = new Node(10);
        Node c1 = new Node(20);
        Node c2 = new Node(30);

        root.child = c1;
        c1.sibling = c2;

        c1.parent = root;
        c2.parent = root;

        System.out.println("Before increase: " + c1.key);

        increaseKey(c1, 40);

        System.out.println("After increase: " + c1.key);
    }
}
