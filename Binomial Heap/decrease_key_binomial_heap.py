# File: decrease_key_binomial_heap.py

class Node:

    def __init__(self, key):
        self.key = key
        self.parent = None
        self.child = None
        self.sibling = None


def decrease_key(node, new_key):

    if new_key > node.key:
        print("New key is greater than current key")
        return

    node.key = new_key
    parent = node.parent

    while parent and node.key < parent.key:

        node.key, parent.key = parent.key, node.key

        node = parent
        parent = node.parent


# Example
root = Node(10)
c1 = Node(20)
c2 = Node(30)

root.child = c1
c1.sibling = c2

c1.parent = root
c2.parent = root

print("Before decrease:", c1.key)

decrease_key(c1, 5)

print("After decrease, new root value:", root.key)
