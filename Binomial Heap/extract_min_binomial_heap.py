# File: extract_min_binomial_heap.py

class Node:

    def __init__(self, key):
        self.key = key
        self.parent = None
        self.child = None
        self.sibling = None


def find_min(head):

    min_node = head
    curr = head

    while curr:
        if curr.key < min_node.key:
            min_node = curr
        curr = curr.sibling

    return min_node


def reverse(node):

    prev = None
    curr = node

    while curr:
        nxt = curr.sibling
        curr.sibling = prev
        curr.parent = None
        prev = curr
        curr = nxt

    return prev


def extract_min(heap):

    if heap is None:
        return None

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

    child_heap = reverse(min_node.child)

    print("Extracted Min:", min_node.key)

    return child_heap


# Example
h1 = Node(10)
h2 = Node(5)
h3 = Node(20)

h1.sibling = h2
h2.sibling = h3

heap = h1

heap = extract_min(heap)
