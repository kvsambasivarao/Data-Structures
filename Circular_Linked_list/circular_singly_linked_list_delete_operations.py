# File Name: circular_singly_linked_list_delete_operations.py
# Program to delete a node at beginning, end, and given position
# in a circular singly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

head = None

# Delete at beginning
def delete_beg():
    global head
    if head is None:
        print("List is empty")
        return

    if head.next == head:
        head = None
        return

    temp = head
    last = head
    while last.next != head:
        last = last.next

    head = head.next
    last.next = head

# Delete at end
def delete_end():
    global head
    if head is None:
        print("List is empty")
        return

    if head.next == head:
        head = None
        return

    temp = head
    prev = None
    while temp.next != head:
        prev = temp
        temp = temp.next

    prev.next = head

# Delete at given position (1-based)
def delete_pos(pos):
    global head
    if head is None:
        print("List is empty")
        return

    if pos == 1:
        delete_beg()
        return

    temp = head
    prev = None
    i = 1

    while i < pos and temp.next != head:
        prev = temp
        temp = temp.next
        i += 1

    if i != pos:
        print("Invalid position")
        return

    prev.next = temp.next

if __name__ == "__main__":
    delete_beg()
    delete_end()
    delete_pos(2)
