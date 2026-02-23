// File: ThreadedBinaryTree.java

class Node {
    int data;
    Node left, right;
    boolean lThread, rThread;

    Node(int data) {
        this.data = data;
        lThread = rThread = true;
    }
}

public class ThreadedBinaryTree {

    Node root;

    public void insert(int key) {
        Node parent = null, current = root;

        while (current != null) {
            if (key == current.data)
                return;

            parent = current;

            if (key < current.data) {
                if (!current.lThread)
                    current = current.left;
                else
                    break;
            } else {
                if (!current.rThread)
                    current = current.right;
                else
                    break;
            }
        }

        Node node = new Node(key);

        if (parent == null)
            root = node;
        else if (key < parent.data) {
            node.left = parent.left;
            node.right = parent;
            parent.lThread = false;
            parent.left = node;
        } else {
            node.left = parent;
            node.right = parent.right;
            parent.rThread = false;
            parent.right = node;
        }
    }

    public void inorder() {
        Node current = root;
        while (current != null && !current.lThread)
            current = current.left;

        while (current != null) {
            System.out.print(current.data + " ");
            if (current.rThread)
                current = current.right;
            else {
                current = current.right;
                while (current != null && !current.lThread)
                    current = current.left;
            }
        }
    }

    public Node search(int key) {
        Node current = root;

        while (current != null) {
            if (key == current.data)
                return current;

            if (key < current.data) {
                if (!current.lThread)
                    current = current.left;
                else
                    break;
            } else {
                if (!current.rThread)
                    current = current.right;
                else
                    break;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ThreadedBinaryTree tree = new ThreadedBinaryTree();

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(25);

        System.out.println("Inorder Traversal:");
        tree.inorder();
    }
}
