# File Name: double_threaded_binary_tree.py

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        self.lTag = 1
        self.rTag = 1

def insert(root, key):
    parent = None
    current = root

    while current:
        parent = current
        if key < current.data:
            if current.lTag == 0:
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
        new_node.left = parent.left
        new_node.right = parent
        parent.lTag = 0
        parent.left = new_node
    else:
        new_node.right = parent.right
        new_node.left = parent
        parent.rTag = 0
        parent.right = new_node

    return root

def left_most(node):
    while node and node.lTag == 0:
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

def search(root, key):
    while root:
        if key == root.data:
            return root
        if key < root.data:
            if root.lTag == 0:
                root = root.left
            else:
                return None
        else:
            if root.rTag == 0:
                root = root.right
            else:
                return None
    return None

root = None
root = insert(root, 15)
root = insert(root, 12)
root = insert(root, 22)
root = insert(root, 8)
root = insert(root, 14)

print("Inorder Traversal:")
inorder(root)

print("\nSearching 22...")
if search(root, 22):
    print("Found")
else:
    print("Not Found")
