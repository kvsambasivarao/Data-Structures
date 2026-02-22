# File: splay_tree.py

class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None


class SplayTree:

    def __init__(self):
        self.root = None

    def right_rotate(self, x):
        y = x.left
        x.left = y.right
        y.right = x
        return y

    def left_rotate(self, x):
        y = x.right
        x.right = y.left
        y.left = x
        return y

    def splay(self, root, key):
        if not root or root.key == key:
            return root

        if key < root.key:
            if not root.left:
                return root
            if key < root.left.key:
                root.left.left = self.splay(root.left.left, key)
                root = self.right_rotate(root)
            elif key > root.left.key:
                root.left.right = self.splay(root.left.right, key)
                if root.left.right:
                    root.left = self.left_rotate(root.left)
            return root if not root.left else self.right_rotate(root)
        else:
            if not root.right:
                return root
            if key > root.right.key:
                root.right.right = self.splay(root.right.right, key)
                root = self.left_rotate(root)
            elif key < root.right.key:
                root.right.left = self.splay(root.right.left, key)
                if root.right.left:
                    root.right = self.right_rotate(root.right)
            return root if not root.right else self.left_rotate(root)

    def insert(self, key):
        if not self.root:
            self.root = Node(key)
            return

        self.root = self.splay(self.root, key)

        if self.root.key == key:
            return

        node = Node(key)

        if key < self.root.key:
            node.right = self.root
            node.left = self.root.left
            self.root.left = None
        else:
            node.left = self.root
            node.right = self.root.right
            self.root.right = None

        self.root = node

    def delete(self, key):
        if not self.root:
            return

        self.root = self.splay(self.root, key)

        if self.root.key != key:
            return

        if not self.root.left:
            self.root = self.root.right
        else:
            temp = self.root
            self.root = self.splay(self.root.left, key)
            self.root.right = temp.right

    def search(self, key):
        self.root = self.splay(self.root, key)

    def inorder(self, root):
        if root:
            self.inorder(root.left)
            print(root.key, end=" ")
            self.inorder(root.right)


if __name__ == "__main__":
    tree = SplayTree()

    tree.insert(10)
    tree.insert(20)
    tree.insert(30)
    tree.insert(40)

    tree.search(20)
    tree.delete(30)

    print("Inorder traversal of Splay Tree:")
    tree.inorder(tree.root)
