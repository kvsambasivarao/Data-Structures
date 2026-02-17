// File Name: RightThreadedBinaryTree.java

class Node {
    int data;
    Node left, right;
    int rTag; // 0 = child, 1 = thread

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.rTag = 1;
    }
}

public class RightThreadedBinaryTree {

    static Node insert(Node root, int key) {
        Node parent = null, current = root;

        while (current != null) {
            parent = current;
            if (key < current.data) {
                if (current.left != null)
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
            parent.left = newNode;
            newNode.right = parent;
        } else {
            newNode.right = parent.right;
            parent.right = newNode;
            parent.rTag = 0;
        }

        return root;
    }

    static Node leftMost(Node node) {
        while (node != null && node.left != null)
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

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 15);
        root = insert(root, 12);
        root = insert(root, 22);
        root = insert(root, 8);
        root = insert(root, 14);

        System.out.println("Inorder Traversal:");
        inorder(root);
    }
}
