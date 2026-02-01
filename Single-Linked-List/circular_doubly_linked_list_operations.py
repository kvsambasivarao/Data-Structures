# File Name: circular_doubly_linked_list.py
# Operations:
# 1. Insert at beginning
# 2. Insert at end
# 3. Delete from beginning
# 4. Delete from end
# 5. Display list

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

class CircularDoublyLinkedList:
    def __init__(self):
        self.head = None

    # Insert at beginning
    def insert_beg(self):
        value = int(input("Enter data: "))
        new_node = Node(value)

        if self.head is None:
            new_node.next = new_node
            new_node.prev = new_node
            self.head = new_node
        else:
            last = self.head.prev
            new_node.next = self.head
            new_node.prev = last
            last.next = new_node
            self.head.prev = new_node
            self.head = new_node

    # Insert at end
    def insert_end(self):
        value = int(input("Enter data: "))
        new_node = Node(value)

        if self.head is None:
            new_node.next = new_node
            new_node.prev = new_node
            self.head = new_node
        else:
            last = self.head.prev
            new_node.next = self.head
            new_node.prev = last
            last.next = new_node
            self.head.prev = new_node

    # Delete from beginning
    def delete_beg(self):
        if self.head is None:
            print("List is empty")
            return

        if self.head.next == self.head:
            self.head = None
        else:
            last = self.head.prev
            self.head = self.head.next
            self.head.prev = last
            last.next = self.head

    # Delete from end
    def delete_end(self):
        if self.head is None:
            print("List is empty")
            return

        if self.head.next == self.head:
            self.head = None
        else:
            last = self.head.prev
            prev_node = last.prev
            prev_node.next = self.head
            self.head.prev = prev_node

    # Display list
    def display(self):
        if self.head is None:
            print("List is empty")
            return

        temp = self.head
        while True:
            print(temp.data, end=" <-> ")
            temp = temp.next
            if temp == self.head:
                break
        print("(back to head)")
