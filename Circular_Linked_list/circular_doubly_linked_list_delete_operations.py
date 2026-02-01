# File Name: circular_doubly_linked_list_delete_operations.py
# Program to delete a node at beginning, end, and given position
# in a circular doubly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
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

    last = head.prev
    head = head.next
    head.prev = last
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

    last = head.prev
    second_last = last.prev
    second_last.next = head
    head.prev = second_last

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
    i = 1
    while i < pos and temp.next != head:
        temp = temp.next
        i += 1

    if i != pos:
        print("Invalid position")
        return

    temp.prev.next = temp.next
    temp.next.prev = temp.prev

if __name__ == "__main__":
    delete_beg()
    delete_end()
    delete_pos(2)
