# File Name: doubly_linked_list_create_node.py
# Program to create a node in a doubly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

# Function to create a new node
def create_node(value):
    return Node(value)

if __name__ == "__main__":
    node1 = create_node(10)
