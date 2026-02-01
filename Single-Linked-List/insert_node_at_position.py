# File Name: insert_at_position.py

# Node class
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

# Singly Linked List class
class SinglyLinkedList:
    def __init__(self):
        self.head = None

    # Method to insert at a given position
    def insert_pos(self, pos):
        value = int(input("Enter data for new node: "))
        new_node = Node(value)

        # Insert at beginning
        if pos == 1:
            new_node.next = self.head
            self.head = new_node
            return

        temp = self.head
        for _ in range(pos - 2):
            if temp is None:
                print("Invalid position")
                return
            temp = temp.next

        new_node.next = temp.next
        temp.next = new_node
