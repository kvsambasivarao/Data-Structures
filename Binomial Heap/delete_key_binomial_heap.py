# File: delete_key_binomial_heap.py

class Node:

    def __init__(self, key):
        self.key = key
        self.parent = None
        self.child = None
        self.sibling = None


def decrease_key(node, new_key):

    node.key = new_key
    parent = node.parent

    while parent and node.key < parent.key:
        node.key, parent.key = parent.key, node.key
        node = parent
        parent = node.parent


def extract_min(heap):

    min_node = heap
    min_prev = None
    prev = None
    curr = heap

    while curr:

        if curr.key < min_node.key:
            min_node = curr
            min_prev = prev

        prev = curr
        curr = curr.sibling

    if min_prev:
        min_prev.sibling = min_node.sibling
    else:
        heap = min_node.sibling

    print("Deleted key:", min_node.key)

    return heap


def delete_key(heap, node):

    decrease_key(node, float('-inf'))
    heap = extract_min(heap)

    return heap


# Example
root = Node(10)
c1 = Node(20)
c2 = Node(30)

root.child = c1
c1.sibling = c2

c1.parent = root
c2.parent = root

heap = root

heap = delete_key(heap, c1)
