# File Name: tree_sort.py

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def insert(root, data):
    if root is None:
        return Node(data)

    if data < root.data:
        root.left = insert(root.left, data)
    else:
        root.right = insert(root.right, data)

    return root

def inorder(root):
    if root:
        inorder(root.left)
        print(root.data, end=" ")
        inorder(root.right)


# Driver Code
arr = [64, 34, 25, 12, 22, 11, 90]

root = None

print("Original Array:")
for value in arr:
    print(value, end=" ")
    root = insert(root, value)

print("\nSorted Array:")
inorder(root)
