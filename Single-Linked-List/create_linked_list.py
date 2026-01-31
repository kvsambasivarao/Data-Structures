# Node class
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

# Linked List class
class SinglyLinkedList:
    def __init__(self):
        self.head = None

    # Method to create list
    def create_list(self, n):
        for i in range(1, n + 1):
            value = int(input(f"Enter data for node {i}: "))
            new_node = Node(value)

            if self.head is None:
                self.head = new_node
            else:
                temp = self.head
                while temp.next:
                    temp = temp.next
                temp.next = new_node
