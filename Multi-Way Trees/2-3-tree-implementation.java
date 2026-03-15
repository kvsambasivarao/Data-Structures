// File: 2-3-tree-implementation.java
// Program implementing 2-3 Tree operations

class Node {
    int keys[] = new int[2];
    Node children[] = new Node[3];
    int numKeys = 0;
    boolean leaf = true;
}

public class TwoThreeTree {

    Node root = new Node();

    void traverse(Node node) {
        if(node == null) return;

        for(int i=0;i<node.numKeys;i++) {
            if(!node.leaf)
                traverse(node.children[i]);

            System.out.print(node.keys[i] + " ");
        }

        if(!node.leaf)
            traverse(node.children[node.numKeys]);
    }

    Node search(Node node, int key) {

        int i=0;

        while(i<node.numKeys && key>node.keys[i])
            i++;

        if(i<node.numKeys && key==node.keys[i])
            return node;

        if(node.leaf)
            return null;

        return search(node.children[i],key);
    }

    void insert(int key) {

        if(root.numKeys < 2) {
            root.keys[root.numKeys++] = key;
        }
    }

    public static void main(String args[]) {

        TwoThreeTree tree = new TwoThreeTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);

        System.out.println("Traversal:");
        tree.traverse(tree.root);

    }
}
