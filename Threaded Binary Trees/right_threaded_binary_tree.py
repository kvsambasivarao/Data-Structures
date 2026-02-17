# File Name: right_threaded_binary_tree.py

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        self.rTag = 1  # 1 = thread

def insert(root, key):
    parent = None
    current = root

    while current:
        parent = current
        if key < current.data:
            if current.left:
                current = current.left
            else:
                break
        else:
            if current.rTag == 0:
                current = current.right
            else:
                break

    new_node = Node(key)

    if parent is None:
        root = new_node
    elif key < parent.data:
        parent.left = new_node
        new_node.right = parent
    else:
        new_node.right = parent.right
        parent.right = new_node
        parent.rTag = 0

    return root

def left_most(node):
    while node and node.left:
        node = node.left
    return node

def inorder(root):
    current = left_most(root)
    while current:
        print(current.data, end=" ")
        if current.rTag == 1:
            current = current.right
        else:
            current = left_most(current.right)

root = None
root = insert(root, 15)
root = insert(root, 12)
root = insert(root, 22)
root = insert(root, 8)
root = insert(root, 14)

print("Inorder Traversal:")
inorder(root)
