// File Name: DoubleThreadedBinaryTree.java

class Node {
    int data;
    Node left, right;
    int lTag, rTag;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.lTag = 1;
        this.rTag = 1;
    }
}

public class DoubleThreadedBinaryTree {

    static Node insert(Node root, int key) {
        Node parent = null, current = root;

        while (current != null) {
            parent = current;

            if (key < current.data) {
                if (current.lTag == 0)
                    current = current.left;
                else break;
            } else {
                if (current.rTag == 0)
                    current = current.right;
                else break;
            }
        }

        Node newNode = new Node(key);

        if (parent == null)
            root = newNode;
        else if (key < parent.data) {
            newNode.left = parent.left;
            newNode.right = parent;
            parent.lTag = 0;
            parent.left = newNode;
        } else {
            newNode.right = parent.right;
            newNode.left = parent;
            parent.rTag = 0;
            parent.right = newNode;
        }

        return root;
    }

    static Node leftMost(Node node) {
        while (node != null && node.lTag == 0)
            node = node.left;
        return node;
    }

    static void inorder(Node root) {
        Node current = leftMost(root);
        while (current != null) {
            System.out.print(current.data + " ");
            if (current.rTag == 1)
                current = current.right;
            else
                current = leftMost(current.right);
        }
    }

    static Node search(Node root, int key) {
        while (root != null) {
            if (key == root.data)
                return root;

            if (key < root.data) {
                if (root.lTag == 0)
                    root = root.left;
                else return null;
            } else {
                if (root.rTag == 0)
                    root = root.right;
                else return null;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 15);
        root = insert(root, 12);
        root = insert(root, 22);
        root = insert(root, 8);
        root = insert(root, 14);

        System.out.println("Inorder Traversal:");
        inorder(root);

        System.out.println("\nSearching 22...");
        if (search(root, 22) != null)
            System.out.println("Found");
        else
            System.out.println("Not Found");
    }
}
