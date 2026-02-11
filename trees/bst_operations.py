class Node:
    def __init__(self, value):
        self.data = value
        self.left = None
        self.right = None

# Insert node
def insert(root, value):
    if root is None:
        return Node(value)
    if value < root.data:
        root.left = insert(root.left, value)
    elif value > root.data:
        root.right = insert(root.right, value)
    return root

# Find minimum value node
def min_value_node(node):
    current = node
    while current.left:
        current = current.left
    return current

# Delete node
def delete_node(root, value):
    if root is None:
        return root

    if value < root.data:
        root.left = delete_node(root.left, value)
    elif value > root.data:
        root.right = delete_node(root.right, value)
    else:
        if root.left is None:
            return root.right
        elif root.right is None:
            return root.left

        temp = min_value_node(root.right)
        root.data = temp.data
        root.right = delete_node(root.right, temp.data)

    return root

# Inorder traversal
def inorder(root):
    if root:
        inorder(root.left)
        print(root.data, end=" ")
        inorder(root.right)

# Driver code
root = None
values = [50, 30, 70, 20, 40, 60, 80]

for v in values:
    root = insert(root, v)

print("Inorder Traversal:", end=" ")
inorder(root)

root = delete_node(root, 20)
print("\nAfter Deletion:", end=" ")
inorder(root)
