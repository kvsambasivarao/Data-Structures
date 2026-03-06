# File: find_min_binomial_heap.py

class Node:
    def __init__(self, key):
        self.key = key
        self.sibling = None


def find_min(head):

    if head is None:
        return None

    min_node = head
    current = head.sibling

    while current is not None:

        if current.key < min_node.key:
            min_node = current

        current = current.sibling

    return min_node


# Example usage
n1 = Node(10)
n2 = Node(5)
n3 = Node(20)

n1.sibling = n2
n2.sibling = n3

minimum = find_min(n1)

if minimum:
    print("Minimum key in Binomial Heap:", minimum.key)
