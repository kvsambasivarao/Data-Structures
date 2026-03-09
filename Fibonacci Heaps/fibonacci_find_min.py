# File: fibonacci_find_min.py
# Program: Find the minimum key in a Fibonacci Heap

class Node:
    def __init__(self, key):
        self.key = key
        self.left = self
        self.right = self


class FibonacciHeap:

    def __init__(self):
        self.min = None

    def insert(self, key):

        node = Node(key)

        if self.min is None:
            self.min = node
        else:

            node.left = self.min
            node.right = self.min.right
            self.min.right.left = node
            self.min.right = node

            if node.key < self.min.key:
                self.min = node

    def find_min(self):

        if self.min is None:
            print("Heap is empty")
        else:
            print("Minimum key in Fibonacci Heap:", self.min.key)


heap = FibonacciHeap()

heap.insert(10)
heap.insert(3)
heap.insert(15)
heap.insert(6)

heap.find_min()
