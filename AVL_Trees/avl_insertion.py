# File: avl_insertion.py

class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None
        self.height = 1


class AVLTree:

    def height(self, node):
        return 0 if not node else node.height

    def getBalance(self, node):
        return 0 if not node else self.height(node.left) - self.height(node.right)

    def rightRotate(self, y):
        x = y.left
        T2 = x.right

        x.right = y
        y.left = T2

        y.height = 1 + max(self.height(y.left), self.height(y.right))
        x.height = 1 + max(self.height(x.left), self.height(x.right))

        return x

    def leftRotate(self, x):
        y = x.right
        T2 = y.left

        y.left = x
        x.right = T2

        x.height = 1 + max(self.height(x.left), self.height(x.right))
        y.height = 1 + max(self.height(y.left), self.height(y.right))

        return y

    def insert(self, node, key):

        if not node:
            return Node(key)

        if key < node.key:
            node.left = self.insert(node.left, key)
        elif key > node.key:
            node.right = self.insert(node.right, key)
        else:
            return node

        node.height = 1 + max(self.height(node.left),
                              self.height(node.right))

        balance = self.getBalance(node)

        if balance > 1 and key < node.left.key:
            return self.rightRotate(node)

        if balance < -1 and key > node.right.key:
            return self.leftRotate(node)

        if balance > 1 and key > node.left.key:
            node.left = self.leftRotate(node.left)
            return self.rightRotate(node)

        if balance < -1 and key < node.right.key:
            node.right = self.rightRotate(node.right)
            return self.leftRotate(node)

        return node

    def inorder(self, root):
        if root:
            self.inorder(root.left)
            print(root.key, end=" ")
            self.inorder(root.right)


if __name__ == "__main__":
    tree = AVLTree()
    root = None

    values = [10, 20, 30, 40, 50, 25]

    for v in values:
        root = tree.insert(root, v)

    print("Inorder traversal after AVL insertion:")
    tree.inorder(root)
