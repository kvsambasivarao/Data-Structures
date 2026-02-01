# File Name: singly_linked_list_count_nodes_recursive.py
# Program to count the number of nodes in a singly linked list using recursion

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

head = None

# Recursive function to count nodes
def count_nodes(node):
    if node is None:
        return 0
    return 1 + count_nodes(node.next)

if __name__ == "__main__":
    print("Number of nodes =", count_nodes(head))
