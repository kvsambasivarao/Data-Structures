// File Name: TreeSort.java

class TreeSort {

    class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    Node root;

    // Insert into BST
    Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    // Inorder Traversal
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};

        TreeSort tree = new TreeSort();

        System.out.println("Original Array:");
        for (int value : arr) {
            System.out.print(value + " ");
            tree.root = tree.insert(tree.root, value);
        }

        System.out.println("\nSorted Array:");
        tree.inorder(tree.root);
    }
}
