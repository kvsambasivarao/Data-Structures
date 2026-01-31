# File Name: insert_at_end.py

# Node class
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

# Singly Linked List class
class SinglyLinkedList:
    def __init__(self):
        self.head = None

    # Method to insert a node at the end
    def insert_end(self):
        value = int(input("Enter data for new node: "))
        new_node = Node(value)

        # If list is empty
        if self.head is None:
            self.head = new_node
        else:
            temp = self.head
            while temp.next:
                temp = temp.next
            temp.next = new_node
