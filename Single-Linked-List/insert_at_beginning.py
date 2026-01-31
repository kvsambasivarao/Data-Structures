# Node class
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

# Singly Linked List class
class SinglyLinkedList:
    def __init__(self):
        self.head = None

    # Method to insert at beginning
    def insert_beg(self):
        value = int(input("Enter data for new node: "))
        new_node = Node(value)

        new_node.next = self.head   # Link new node
        self.head = new_node        # Update head
