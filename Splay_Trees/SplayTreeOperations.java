// File: SplayTree.java

class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
    }
}

public class SplayTree {

    Node root;

    private Node rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    private Node splay(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key < root.key) {
            if (root.left == null) return root;

            if (key < root.left.key) {
                root.left.left = splay(root.left.left, key);
                root = rightRotate(root);
            } else if (key > root.left.key) {
                root.left.right = splay(root.left.right, key);
                if (root.left.right != null)
                    root.left = leftRotate(root.left);
            }
            return (root.left == null) ? root : rightRotate(root);
        } else {
            if (root.right == null) return root;

            if (key > root.right.key) {
                root.right.right = splay(root.right.right, key);
                root = leftRotate(root);
            } else if (key < root.right.key) {
                root.right.left = splay(root.right.left, key);
                if (root.right.left != null)
                    root.right = rightRotate(root.right);
            }
            return (root.right == null) ? root : leftRotate(root);
        }
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);

        root = splay(root, key);

        if (root.key == key)
            return root;

        Node node = new Node(key);

        if (key < root.key) {
            node.right = root;
            node.left = root.left;
            root.left = null;
        } else {
            node.left = root;
            node.right = root.right;
            root.right = null;
        }
        return node;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node root, int key) {
        if (root == null)
            return null;

        root = splay(root, key);

        if (root.key != key)
            return root;

        if (root.left == null)
            return root.right;

        Node temp = root;
        root = splay(root.left, key);
        root.right = temp.right;

        return root;
    }

    public void search(int key) {
        root = splay(root, key);
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        SplayTree tree = new SplayTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);

        tree.search(20);
        tree.delete(30);

        System.out.println("Inorder traversal of Splay Tree:");
        tree.inorder(tree.root);
    }
}
