# File: fibonacci_marking.py
# Program: Demonstrate node marking and cascading cut in Fibonacci Heap

class Node:
    def __init__(self, key):
        self.key = key
        self.mark = False
        self.parent = None

def cut(child, parent):

    print(f"Cut node {child.key} from parent {parent.key}")

    child.parent = None

    if not parent.mark:
        parent.mark = True
        print(f"Node {parent.key} marked (first child cut)")
    else:
        print(f"Node {parent.key} cut due to second child loss (cascading cut)")


parent = Node(10)
child1 = Node(20)
child2 = Node(30)

child1.parent = parent
child2.parent = parent

cut(child1, parent)
cut(child2, parent)
