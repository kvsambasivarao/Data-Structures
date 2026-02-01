# File Name: doubly_linked_list_create_n_nodes.py
# Program to create a doubly linked list with n nodes

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

head = None

# Function to create doubly linked list with n nodes
def create_list(n):
    global head
    temp = None

    for i in range(1, n + 1):
        value = int(input(f"Enter data for node {i}: "))
        new_node = Node(value)

        if head is None:
            head = new_node
            temp = head
        else:
            temp.next = new_node
            new_node.prev = temp
            temp = new_node

if __name__ == "__main__":
    n = int(input("Enter number of nodes: "))
    create_list(n)
