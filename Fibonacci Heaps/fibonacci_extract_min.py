# File: fibonacci_extract_min.py
# Program: Illustrate extracting the minimum key from a Fibonacci Heap

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

    def extract_min(self):

        if self.min is None:
            print("Heap is empty")
            return

        temp = self.min
        print("Extracted minimum key:", temp.key)

        if temp.right == temp:
            self.min = None
        else:
            temp.left.right = temp.right
            temp.right.left = temp.left
            self.min = temp.right

    def display(self):

        if self.min is None:
            print("Heap is empty")
            return

        temp = self.min
        print("Heap nodes:", end=" ")

        while True:
            print(temp.key, end=" ")
            temp = temp.right
            if temp == self.min:
                break

        print()


heap = FibonacciHeap()

heap.insert(10)
heap.insert(3)
heap.insert(15)
heap.insert(6)

heap.display()

heap.extract_min()

heap.display()
