# File: avl_deletion.py

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

    def minValueNode(self, node):
        current = node
        while current.left:
            current = current.left
        return current

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

    def deleteNode(self, root, key):

        if not root:
            return root

        if key < root.key:
            root.left = self.deleteNode(root.left, key)
        elif key > root.key:
            root.right = self.deleteNode(root.right, key)
        else:

            if not root.left:
                return root.right
            elif not root.right:
                return root.left

            temp = self.minValueNode(root.right)
            root.key = temp.key
            root.right = self.deleteNode(root.right, temp.key)

        root.height = 1 + max(self.height(root.left),
                              self.height(root.right))

        balance = self.getBalance(root)

        if balance > 1 and self.getBalance(root.left) >= 0:
            return self.rightRotate(root)

        if balance > 1 and self.getBalance(root.left) < 0:
            root.left = self.leftRotate(root.left)
            return self.rightRotate(root)

        if balance < -1 and self.getBalance(root.right) <= 0:
            return self.leftRotate(root)

        if balance < -1 and self.getBalance(root.right) > 0:
            root.right = self.rightRotate(root.right)
            return self.leftRotate(root)

        return root


if __name__ == "__main__":

    tree = AVLTree()
    root = None

    values = [10, 20, 30, 40, 50, 25]

    for v in values:
        root = tree.insert(root, v)

    print("Inorder before deletion:")
    tree.insert
    def inorder(node):
        if node:
            inorder(node.left)
            print(node.key, end=" ")
            inorder(node.right)

    inorder(root)

    root = tree.deleteNode(root, 40)

    print("\nInorder after deleting 40:")
    inorder(root)
