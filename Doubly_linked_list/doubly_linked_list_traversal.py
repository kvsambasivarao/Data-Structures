# File Name: doubly_linked_list_traversal.py
# Program to traverse a doubly linked list left to right and right to left

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

head = None

# Traverse left to right
def traverse_forward():
    global head
    if head is None:
        print("List is empty")
        return
    temp = head
    print("Forward traversal:", end=" ")
    while temp:
        print(temp.data, end=" <-> ")
        temp = temp.next
    print("NULL")

# Traverse right to left
def traverse_backward():
    global head
    if head is None:
        print("List is empty")
        return
    temp = head
    while temp.next:
        temp = temp.next
    print("Backward traversal:", end=" ")
    while temp:
        print(temp.data, end=" <-> ")
        temp = temp.prev
    print("NULL")

if __name__ == "__main__":
    traverse_forward()
    traverse_backward()
