// File: b-star-tree-implementation.java
// Program implementing B* Tree operations

class Node {

    int keys[] = new int[4];
    Node children[] = new Node[5];
    int numKeys = 0;
    boolean leaf = true;
}

public class BStarTree {

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
        if(root.numKeys < 4)
        {
            root.keys[root.numKeys++] = key;
        }
    }

    public static void main(String args[])
    {
        BStarTree tree = new BStarTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(30);

        System.out.println("Traversal of B* Tree:");

        tree.traverse(tree.root);
    }
}
