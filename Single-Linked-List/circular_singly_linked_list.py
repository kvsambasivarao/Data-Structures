# File Name: circular_singly_linked_list.py
# Operations:
# 1. Insert at beginning
# 2. Insert at end
# 3. Delete from beginning
# 4. Delete from end
# 5. Display list

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class CircularSinglyLinkedList:
    def __init__(self):
        self.head = None

    # Insert at beginning
    def insert_beg(self):
        value = int(input("Enter data: "))
        new_node = Node(value)

        if self.head is None:
            self.head = new_node
            new_node.next = self.head
        else:
            temp = self.head
            while temp.next != self.head:
                temp = temp.next
            new_node.next = self.head
            temp.next = new_node
            self.head = new_node

    # Insert at end
    def insert_end(self):
        value = int(input("Enter data: "))
        new_node = Node(value)

        if self.head is None:
            self.head = new_node
            new_node.next = self.head
        else:
            temp = self.head
            while temp.next != self.head:
                temp = temp.next
            temp.next = new_node
            new_node.next = self.head

    # Delete from beginning
    def delete_beg(self):
        if self.head is None:
            print("List is empty")
            return

        if self.head.next == self.head:
            self.head = None
        else:
            temp = self.head
            while temp.next != self.head:
                temp = temp.next
            self.head = self.head.next
            temp.next = self.head

    # Delete from end
    def delete_end(self):
        if self.head is None:
            print("List is empty")
            return

        if self.head.next == self.head:
            self.head = None
        else:
            temp = self.head
            while temp.next.next != self.head:
                temp = temp.next
            temp.next = self.head

    # Display list
    def display(self):
        if self.head is None:
            print("List is empty")
            return

        temp = self.head
        while True:
            print(temp.data, end=" -> ")
            temp = temp.next
            if temp == self.head:
                break
        print("(back to head)")
