# File Name: singly_linked_list.py

# Node class
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

# Singly Linked List class
class SinglyLinkedList:
    def __init__(self):
        self.head = None

    # Insert at beginning
    def insert_beg(self):
        value = int(input("Enter data: "))
        new_node = Node(value)
        new_node.next = self.head
        self.head = new_node

    # Insert at end
    def insert_end(self):
        value = int(input("Enter data: "))
        new_node = Node(value)

        if self.head is None:
            self.head = new_node
            return

        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = new_node

    # Delete from beginning
    def delete_beg(self):
        if self.head is None:
            print("List is empty")
            return
        self.head = self.head.next

    # Delete from end
    def delete_end(self):
        if self.head is None:
            print("List is empty")
            return

        if self.head.next is None:
            self.head = None
            return

        temp = self.head
        while temp.next.next:
            temp = temp.next
        temp.next = None

    # Display list
    def display(self):
        temp = self.head
        if temp is None:
            print("List is empty")
            return

        while temp:
            print(temp.data, end=" -> ")
            temp = temp.next
        print("NULL")
