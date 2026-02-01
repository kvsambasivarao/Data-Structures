# File Name: doubly_linked_list_insert_end.py
# Program to insert a node at the end of a doubly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

head = None

# Function to insert at end
def insert_end(value):
    global head
    new_node = Node(value)

    # If list is empty
    if head is None:
        head = new_node
        return

    temp = head
    while temp.next is not None:
        temp = temp.next

    temp.next = new_node
    new_node.prev = temp

if __name__ == "__main__":
    insert_end(10)
