// File: RedBlackSearch.java

class Node {
    int data;
    Node left, right, parent;
    boolean color; // true = RED, false = BLACK

    Node(int data) {
        this.data = data;
        this.color = true;
    }
}

public class RedBlackSearch {

    Node root;

    Node search(Node root, int key) {
        if (root == null || root.data == key)
            return root;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public static void main(String[] args) {

        RedBlackSearch tree = new RedBlackSearch();

        tree.root = new Node(20);
        tree.root.color = false; // BLACK

        tree.root.left = new Node(10);
        tree.root.right = new Node(30);

        int key = 30;

        Node result = tree.search(tree.root, key);

        if (result != null)
            System.out.println("Key " + key + " found in Red-Black Tree.");
        else
            System.out.println("Key " + key + " not found in Red-Black Tree.");
    }
}
