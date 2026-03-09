# File: fibonacci_union.py
# Program: Illustrate union of two Fibonacci Heaps

class Node:
    def __init__(self, key):
        self.key = key
        self.left = self
        self.right = self


class FibonacciHeap:

    def insert(self, min_node, key):

        node = Node(key)

        if min_node is None:
            return node

        node.left = min_node
        node.right = min_node.right
        min_node.right.left = node
        min_node.right = node

        if node.key < min_node.key:
            min_node = node

        return min_node


def union_heap(min1, min2):

    if min1 is None:
        return min2
    if min2 is None:
        return min1

    temp = min1.right
    min1.right = min2.right
    min2.right.left = min1
    min2.right = temp
    temp.left = min2

    return min2 if min2.key < min1.key else min1


def display(min_node):

    if min_node is None:
        return

    temp = min_node
    print("Heap nodes:", end=" ")

    while True:
        print(temp.key, end=" ")
        temp = temp.right
        if temp == min_node:
            break

    print()


heap = FibonacciHeap()

H1 = None
H2 = None

H1 = heap.insert(H1, 10)
H1 = heap.insert(H1, 3)
H1 = heap.insert(H1, 15)

H2 = heap.insert(H2, 7)
H2 = heap.insert(H2, 2)
H2 = heap.insert(H2, 18)

H = union_heap(H1, H2)

display(H)
