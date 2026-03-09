# File: fibonacci_delete_node.py
# Program: Delete a node in a Fibonacci Heap

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

        return node

    def decrease_key(self, node, new_key):

        node.key = new_key

        if node.key < self.min.key:
            self.min = node

    def extract_min(self):

        if self.min is None:
            return

        temp = self.min

        if temp.right == temp:
            self.min = None
        else:
            temp.left.right = temp.right
            temp.right.left = temp.left
            self.min = temp.right

        print("Deleted node with key", temp.key)

    def delete_node(self, node):

        self.decrease_key(node, float('-inf'))
        self.extract_min()


heap = FibonacciHeap()

n1 = heap.insert(10)
n2 = heap.insert(20)

heap.delete_node(n2)
