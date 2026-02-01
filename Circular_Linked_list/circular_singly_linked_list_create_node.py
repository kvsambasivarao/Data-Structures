# File Name: circular_singly_linked_list_create_node.py
# Program to create a node in a circular singly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.next = self   # Circular link

# Function to create a new node
def create_node(value):
    return Node(value)

if __name__ == "__main__":
    head = create_node(10)
