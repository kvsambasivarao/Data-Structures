// File Name: BinaryTree.java
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.left == null) {
                temp.left = newNode;
                return;
            } else q.add(temp.left);

            if (temp.right == null) {
                temp.right = newNode;
                return;
            } else q.add(temp.right);
        }
    }

    boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        return search(root.left, key) || search(root.right, key);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(20);
        bt.insert(30);
        bt.insert(40);

        System.out.print("Inorder: ");
        bt.inorder(bt.root);

        System.out.print("\nPreorder: ");
        bt.preorder(bt.root);

        System.out.print("\nPostorder: ");
        bt.postorder(bt.root);

        System.out.print("\nLevel Order: ");
        bt.levelOrder();

        System.out.println("\nSearch 30: " + bt.search(bt.root, 30));
    }
}
