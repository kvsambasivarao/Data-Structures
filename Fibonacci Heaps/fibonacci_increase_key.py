# File: fibonacci_increase_key.py
# Program: Increase a key value in a Fibonacci Heap

class Node:
    def __init__(self, key):
        self.key = key
        self.left = self
        self.right = self


def increase_key(node, new_key):

    if new_key < node.key:
        print("New key is smaller than current key")
        return

    node.key = new_key
    print("Key increased to", new_key)


node = Node(10)

increase_key(node, 25)
