# File Name: binary_tree.py
from collections import deque

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self):
        self.root = None

    def insert(self, data):
        new_node = Node(data)
        if not self.root:
            self.root = new_node
            return

        q = deque([self.root])
        while q:
            temp = q.popleft()
            if not temp.left:
                temp.left = new_node
                return
            else:
                q.append(temp.left)

            if not temp.right:
                temp.right = new_node
                return
            else:
                q.append(temp.right)

    def search(self, root, key):
        if not root:
            return False
        if root.data == key:
            return True
        return self.search(root.left, key) or self.search(root.right, key)

    def inorder(self, root):
        if root:
            self.inorder(root.left)
            print(root.data, end=" ")
            self.inorder(root.right)

    def preorder(self, root):
        if root:
            print(root.data, end=" ")
            self.preorder(root.left)
            self.preorder(root.right)

    def postorder(self, root):
        if root:
            self.postorder(root.left)
            self.postorder(root.right)
            print(root.data, end=" ")

    def level_order(self):
        q = deque([self.root])
        while q:
            temp = q.popleft()
            print(temp.data, end=" ")
            if temp.left:
                q.append(temp.left)
            if temp.right:
                q.append(temp.right)

bt = BinaryTree()
bt.insert(10)
bt.insert(20)
bt.insert(30)
bt.insert(40)

print("Inorder:", end=" ")
bt.inorder(bt.root)

print("\nPreorder:", end=" ")
bt.preorder(bt.root)

print("\nPostorder:", end=" ")
bt.postorder(bt.root)

print("\nLevel Order:", end=" ")
bt.level_order()

print("\nSearch 30:", bt.search(bt.root, 30))
