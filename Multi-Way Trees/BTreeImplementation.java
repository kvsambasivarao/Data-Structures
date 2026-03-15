// File: BTree.java
// Program implementing B-Tree operations

class BTreeNode {
    int t, n;
    int keys[];
    BTreeNode children[];
    boolean leaf;

    BTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        keys = new int[2*t-1];
        children = new BTreeNode[2*t];
        n = 0;
    }

    void traverse() {
        int i;
        for(i=0;i<n;i++) {
            if(!leaf)
                children[i].traverse();
            System.out.print(keys[i]+" ");
        }

        if(!leaf)
            children[i].traverse();
    }

    BTreeNode search(int k) {
        int i=0;

        while(i<n && k>keys[i])
            i++;

        if(i<n && keys[i]==k)
            return this;

        if(leaf)
            return null;

        return children[i].search(k);
    }
}

public class BTree {

    BTreeNode root;
    int t;

    BTree(int t) {
        this.root=null;
        this.t=t;
    }

    public void traverse() {
        if(root!=null)
            root.traverse();
    }

    public BTreeNode search(int k) {
        if(root==null)
            return null;
        return root.search(k);
    }

    public static void main(String args[]) {

        BTree t = new BTree(3);

        System.out.println("Simple B-Tree structure created");

    }
}
