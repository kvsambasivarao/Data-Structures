# File: increase_key_binomial_heap.py

class Node:

    def __init__(self, key):
        self.key = key
        self.parent = None
        self.child = None
        self.sibling = None


def heapify_down(node):

    while node.child:

        min_child = node.child
        curr = min_child.sibling

        while curr:
            if curr.key < min_child.key:
                min_child = curr
            curr = curr.sibling

        if node.key <= min_child.key:
            break

        node.key, min_child.key = min_child.key, node.key
        node = min_child


def increase_key(node, new_key):

    if new_key < node.key:
        print("New key is smaller than current key")
        return

    node.key = new_key
    heapify_down(node)


# Example
root = Node(10)
c1 = Node(20)
c2 = Node(30)

root.child = c1
c1.sibling = c2

c1.parent = root
c2.parent = root

print("Before increase:", c1.key)

increase_key(c1, 40)

print("After increase:", c1.key)
