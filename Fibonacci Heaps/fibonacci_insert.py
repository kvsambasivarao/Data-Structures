# File: fibonacci_insert.py
# Program: Insert a node into a Fibonacci Heap

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

        print("Inserted node", key)


heap = FibonacciHeap()

heap.insert(10)
heap.insert(4)
heap.insert(15)
heap.insert(2)

print("Current minimum key:", heap.min.key)
