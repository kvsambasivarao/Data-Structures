# File: fibonacci_decrease_key.py
# Program: Decrease a key value in a Fibonacci Heap

class Node:
    def __init__(self, key):
        self.key = key
        self.parent = None
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

        return node

    def decrease_key(self, x, new_key):

        if new_key > x.key:
            print("New key is greater than current key")
            return

        x.key = new_key

        if x.key < self.min.key:
            self.min = x

        print("Key decreased to", new_key)


heap = FibonacciHeap()

n1 = heap.insert(10)
n2 = heap.insert(20)

heap.decrease_key(n2, 5)

print("Current minimum key:", heap.min.key)
