# File Name: doubly_linked_list_insert_beginning.py
# Program to insert a node at the beginning of a doubly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

head = None

# Function to insert at beginning
def insert_beg(value):
    global head
    new_node = Node(value)
    new_node.next = head

    if head is not None:
        head.prev = new_node

    head = new_node

if __name__ == "__main__":
    insert_beg(10)
