# File Name: circular_singly_linked_list_insert_operations.py
# Program to insert a node at beginning, end, and given position
# in a circular singly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

head = None

# Insert at beginning
def insert_beg(value):
    global head
    new_node = Node(value)

    if head is None:
        head = new_node
        new_node.next = head
        return

    temp = head
    while temp.next != head:
        temp = temp.next

    new_node.next = head
    temp.next = new_node
    head = new_node

# Insert at end
def insert_end(value):
    global head
    new_node = Node(value)

    if head is None:
        head = new_node
        new_node.next = head
        return

    temp = head
    while temp.next != head:
        temp = temp.next

    temp.next = new_node
    new_node.next = head

# Insert at given position (1-based)
def insert_pos(value, pos):
    global head
    if head is None or pos == 1:
        insert_beg(value)
        return

    new_node = Node(value)
    temp = head

    for _ in range(1, pos - 1):
        if temp.next == head:
            break
        temp = temp.next

    new_node.next = temp.next
    temp.next = new_node

if __name__ == "__main__":
    insert_beg(10)
    insert_end(20)
    insert_pos(15, 2)
