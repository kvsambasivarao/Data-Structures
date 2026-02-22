// File Name: SplayTree.java
class SplayTree {

    class Node {
        int key;
        Node left, right;

        Node(int d) {
            key = d;
            left = right = null;
        }
    }

    Node root;

    // Right Rotate (Zig)
    Node rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    // Left Rotate (Zag)
    Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    Node splay(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        // Zig-Zig
        if (key < root.key && root.left != null) {
            if (key < root.left.key) {
                root.left.left = splay(root.left.left, key);
                root = rightRotate(root);
            }
            // Zig-Zag
            else if (key > root.left.key) {
                root.left.right = splay(root.left.right, key);
                if (root.left.right != null)
                    root.left = leftRotate(root.left);
            }
            return (root.left == null) ? root : rightRotate(root);
        }

        // Zag-Zag
        if (key > root.key && root.right != null) {
            if (key > root.right.key) {
                root.right.right = splay(root.right.right, key);
                root = leftRotate(root);
            }
            // Zag-Zig
            else if (key < root.right.key) {
                root.right.left = splay(root.right.left, key);
                if (root.right.left != null)
                    root.right = rightRotate(root.right);
            }
            return (root.right == null) ? root : leftRotate(root);
        }

        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        SplayTree tree = new SplayTree();

        tree.root = tree.new Node(100);
        tree.root.left = tree.new Node(50);
        tree.root.right = tree.new Node(200);

        tree.root = tree.splay(tree.root, 50);

        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);
    }
}
