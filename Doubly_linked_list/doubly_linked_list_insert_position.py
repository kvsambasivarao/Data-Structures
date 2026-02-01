# File Name: doubly_linked_list_insert_position.py
# Program to insert a node at a given position in a doubly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

head = None

# Function to insert at a given position (1-based)
def insert_pos(value, pos):
    global head
    new_node = Node(value)

    # Insert at beginning
    if pos == 1:
        new_node.next = head
        if head is not None:
            head.prev = new_node
        head = new_node
        return

    temp = head
    for _ in range(1, pos - 1):
        if temp is None:
            print("Invalid position")
            return
        temp = temp.next

    if temp is None:
        print("Invalid position")
        return

    new_node.next = temp.next
    new_node.prev = temp

    if temp.next is not None:
        temp.next.prev = new_node

    temp.next = new_node

if __name__ == "__main__":
    insert_pos(25, 2)   # example
