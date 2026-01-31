# Definition of Node
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

# Function to create a new node
def create_node():
    value = int(input("Enter data for the node: "))
    new_node = Node(value)
    return new_node
