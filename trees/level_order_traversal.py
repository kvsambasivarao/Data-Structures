# File Name: level_order_traversal.py
from collections import deque

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def level_order(root):
    if not root:
        return

    queue = deque([root])

    while queue:
        temp = queue.popleft()
        print(temp.data, end=" ")

        if temp.left:
            queue.append(temp.left)
        if temp.right:
            queue.append(temp.right)

# Driver code
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)

print("Level Order Traversal:", end=" ")
level_order(root)
