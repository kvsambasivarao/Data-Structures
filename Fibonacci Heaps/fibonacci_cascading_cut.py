# File: fibonacci_cascading_cut.py
# Program: Demonstrate Cascading Cut in Fibonacci Heap

class Node:
    def __init__(self, key):
        self.key = key
        self.mark = False
        self.parent = None


def cascading_cut(y):

    z = y.parent

    if z is not None:

        if not y.mark:
            y.mark = True
            print(f"Node {y.key} marked")

        else:
            print(f"Cascading cut: node {y.key} cut from parent {z.key}")
            y.parent = None
            cascading_cut(z)


parent = Node(10)
child = Node(20)

child.parent = parent

cascading_cut(child)
cascading_cut(child)
