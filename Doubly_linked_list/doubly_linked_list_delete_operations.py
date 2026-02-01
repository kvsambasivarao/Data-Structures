# File Name: doubly_linked_list_delete_operations.py
# Program to delete nodes at beginning, end, and given position in a doubly linked list

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
    head = head.next
    if head:
        head.prev = None

# Delete at end
def delete_end():
    global head
    if head is None:
        print("List is empty")
        return
    if head.next is None:
        head = None
        return
    temp = head
    while temp.next:
        temp = temp.next
    temp.prev.next = None

# Delete at given position
def delete_pos(pos):
    global head
    if head is None:
        print("List is empty")
        return
    if pos == 1:
        delete_beg()
        return
    temp = head
    for _ in range(1, pos):
        if temp is None:
            print("Invalid position")
            return
        temp = temp.next

    if temp is None:
        print("Invalid position")
        return

    if temp.next:
        temp.next.prev = temp.prev
    temp.prev.next = temp.next

if __name__ == "__main__":
    delete_beg()
    delete_end()
    delete_pos(2)
