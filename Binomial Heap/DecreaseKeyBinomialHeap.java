// File: DecreaseKeyBinomialHeap.java

class Node {

    int key;
    Node parent, child, sibling;

    Node(int key){
        this.key = key;
        parent = child = sibling = null;
    }
}

public class DecreaseKeyBinomialHeap {

    static void swap(Node a, Node b){
        int temp = a.key;
        a.key = b.key;
        b.key = temp;
    }

    static void decreaseKey(Node node, int newKey){

        if(newKey > node.key){
            System.out.println("New key is greater than current key");
            return;
        }

        node.key = newKey;
        Node parent = node.parent;

        while(parent != null && node.key < parent.key){
            swap(node, parent);
            node = parent;
            parent = node.parent;
        }
    }

    public static void main(String[] args){

        Node root = new Node(10);
        Node c1 = new Node(20);
        Node c2 = new Node(30);

        root.child = c1;
        c1.sibling = c2;

        c1.parent = root;
        c2.parent = root;

        System.out.println("Before decrease: " + c1.key);

        decreaseKey(c1, 5);

        System.out.println("After decrease, new root value: " + root.key);
    }
}
