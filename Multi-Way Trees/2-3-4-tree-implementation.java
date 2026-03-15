// File: 2-3-4-tree-implementation.java
// Program implementing 2-3-4 Tree operations

class Node {

    int keys[] = new int[3];
    Node children[] = new Node[4];
    int numKeys = 0;
    boolean leaf = true;
}

public class TwoThreeFourTree {

    Node root = new Node();

    void traverse(Node node)
    {
        if(node==null)
            return;

        int i;

        for(i=0;i<node.numKeys;i++)
        {
            if(!node.leaf)
                traverse(node.children[i]);

            System.out.print(node.keys[i]+" ");
        }

        if(!node.leaf)
            traverse(node.children[i]);
    }

    Node search(Node node,int key)
    {
        int i=0;

        while(i<node.numKeys && key>node.keys[i])
            i++;

        if(i<node.numKeys && key==node.keys[i])
            return node;

        if(node.leaf)
            return null;

        return search(node.children[i],key);
    }

    void insert(int key)
    {
        if(root.numKeys<3)
        {
            root.keys[root.numKeys++] = key;
        }
    }

    public static void main(String args[])
    {
        TwoThreeFourTree tree = new TwoThreeFourTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);

        System.out.println("Traversal of 2-3-4 Tree:");

        tree.traverse(tree.root);
    }
}
