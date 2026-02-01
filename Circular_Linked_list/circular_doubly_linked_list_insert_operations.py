# File Name: circular_doubly_linked_list_insert_operations.py
# Program to insert a node at beginning, end, and given position
# in a circular doubly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

head = None

# Insert at beginning
def insert_beg(value):
    global head
    new_node = Node(value)

    if head is None:
        new_node.next = new_node
        new_node.prev = new_node
        head = new_node
        return

    last = head.prev
    new_node.next = head
    new_node.prev = last
    last.next = new_node
    head.prev = new_node
    head = new_node

# Insert at end
def insert_end(value):
    global head
    new_node = Node(value)

    if head is None:
        new_node.next = new_node
        new_node.prev = new_node
        head = new_node
        return

    last = head.prev
    new_node.next = head
    new_node.prev = last
    last.next = new_node
    head.prev = new_node

# Insert at given position (1-based)
def insert_pos(value, pos):
    global head
    if head is None or pos == 1:
        insert_beg(value)
        return

    temp = head
    for _ in range(1, pos - 1):
        if temp.next == head:
            break
        temp = temp.next

    new_node = Node(value)
    new_node.next = temp.next
    new_node.prev = temp
    temp.next.prev = new_node
    temp.next = new_node

if __name__ == "__main__":
    insert_beg(10)
    insert_end(30)
    insert_pos(20, 2)
