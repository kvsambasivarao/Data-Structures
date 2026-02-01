# File Name: circular_doubly_linked_list_traversal.py
# Program to traverse a circular doubly linked list
# forward and backward

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

head = None

# Forward traversal
def traverse_forward():
    global head
    if head is None:
        print("List is empty")
        return

    temp = head
    print("Forward traversal:", end=" ")
    while True:
        print(temp.data, end=" <-> ")
        temp = temp.next
        if temp == head:
            break
    print("HEAD")

# Backward traversal
def traverse_backward():
    global head
    if head is None:
        print("List is empty")
        return

    temp = head.prev  # start from last node
    print("Backward traversal:", end=" ")
    while True:
        print(temp.data, end=" <-> ")
        temp = temp.prev
        if temp == head.prev:
            break
    print("HEAD")

if __name__ == "__main__":
    traverse_forward()
    traverse_backward()
