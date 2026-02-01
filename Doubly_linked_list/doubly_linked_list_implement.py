# File Name: doubly_linked_list.py
# Program to implement a doubly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

head = None

def insert_beg(value):
    global head
    new_node = Node(value)
    new_node.next = head
    if head:
        head.prev = new_node
    head = new_node

def insert_end(value):
    global head
    new_node = Node(value)
    if head is None:
        head = new_node
        return
    temp = head
    while temp.next:
        temp = temp.next
    temp.next = new_node
    new_node.prev = temp

def delete_beg():
    global head
    if head is None:
        print("List is empty")
        return
    head = head.next
    if head:
        head.prev = None

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

def traverse_forward():
    temp = head
    print("Forward:", end=" ")
    while temp:
        print(temp.data, end=" <-> ")
        temp = temp.next
    print("NULL")

def traverse_backward():
    temp = head
    if temp is None:
        return
    while temp.next:
        temp = temp.next
    print("Backward:", end=" ")
    while temp:
        print(temp.data, end=" <-> ")
        temp = temp.prev
    print("NULL")

if __name__ == "__main__":
    insert_beg(10)
    insert_end(20)
    insert_end(30)

    traverse_forward()
    traverse_backward()

    delete_beg()
    delete_end()

    traverse_forward()
