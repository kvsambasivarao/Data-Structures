# File Name: splay_tree.py

class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None


class SplayTree:

    # Right Rotate (Zig)
    def right_rotate(self, x):
        y = x.left
        x.left = y.right
        y.right = x
        return y

    # Left Rotate (Zag)
    def left_rotate(self, x):
        y = x.right
        x.right = y.left
        y.left = x
        return y

    def splay(self, root, key):
        if root is None or root.key == key:
            return root

        # Zig-Zig
        if key < root.key and root.left:
            if key < root.left.key:
                root.left.left = self.splay(root.left.left, key)
                root = self.right_rotate(root)
            # Zig-Zag
            elif key > root.left.key:
                root.left.right = self.splay(root.left.right, key)
                if root.left.right:
                    root.left = self.left_rotate(root.left)
            return root if not root.left else self.right_rotate(root)

        # Zag-Zag
        if key > root.key and root.right:
            if key > root.right.key:
                root.right.right = self.splay(root.right.right, key)
                root = self.left_rotate(root)
            # Zag-Zig
            elif key < root.right.key:
                root.right.left = self.splay(root.right.left, key)
                if root.right.left:
                    root.right = self.right_rotate(root.right)
            return root if not root.right else self.left_rotate(root)

        return root

    def inorder(self, root):
        if root:
            self.inorder(root.left)
            print(root.key, end=" ")
            self.inorder(root.right)


if __name__ == "__main__":
    tree = SplayTree()

    root = Node(100)
    root.left = Node(50)
    root.right = Node(200)

    root = tree.splay(root, 50)

    print("Inorder Traversal:")
    tree.inorder(root)
