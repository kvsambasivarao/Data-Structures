// File: RedBlackInsert.java

class Node {
    int data;
    Node left, right, parent;
    boolean color; // true = RED, false = BLACK

    Node(int data) {
        this.data = data;
        color = true;
    }
}

public class RedBlackInsert {

    private Node root;
    private final boolean RED = true;
    private final boolean BLACK = false;

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;

        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != null)
            x.right.parent = y;

        x.parent = y.parent;
        if (y.parent == null)
            root = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        x.right = y;
        y.parent = x;
    }

    public void insert(int data) {
        Node z = new Node(data);
        Node y = null;
        Node x = root;

        while (x != null) {
            y = x;
            if (z.data < x.data)
                x = x.left;
            else
                x = x.right;
        }

        z.parent = y;
        if (y == null)
            root = z;
        else if (z.data < y.data)
            y.left = z;
        else
            y.right = z;

        fixInsert(z);
    }

    private void fixInsert(Node z) {
        while (z.parent != null && z.parent.color == RED) {
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;
                if (y != null && y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    rightRotate(z.parent.parent);
                }
            } else {
                Node y = z.parent.parent.left;
                if (y != null && y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        RedBlackInsert tree = new RedBlackInsert();
        int[] values = {10, 20, 30, 15, 25, 5};

        for (int v : values)
            tree.insert(v);

        System.out.println("Inorder traversal of Red-Black Tree:");
        tree.inorder(tree.root);
    }
}
