# File: fibonacci_heap.py
# Program: Create a Fibonacci Heap and insert nodes

class Node:
    def __init__(self, key):
        self.key = key
        self.degree = 0
        self.parent = None
        self.child = None
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

    def display(self):

        if self.min is None:
            return

        temp = self.min
        print("Root List:", end=" ")

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
