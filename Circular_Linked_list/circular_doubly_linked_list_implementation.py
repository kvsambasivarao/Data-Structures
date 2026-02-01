# File Name: circular_doubly_linked_list.py
# Program to implement a circular doubly linked list with basic operations

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

head = None

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

def traverse_forward():
    if head is None:
        print("List is empty")
        return

    temp = head
    print("Forward:", end=" ")
    while True:
        print(temp.data, end=" <-> ")
        temp = temp.next
        if temp == head:
            break
    print("HEAD")

def traverse_backward():
    if head is None:
        print("List is empty")
        return

    temp = head.prev
    print("Backward:", end=" ")
    while True:
        print(temp.data, end=" <-> ")
        temp = temp.prev
        if temp == head.prev:
            break
    print("HEAD")

if __name__ == "__main__":
    insert_beg(10)
    insert_end(20)
    insert_end(30)

    traverse_forward()
    traverse_backward()

    delete_beg()
    delete_end()

    traverse_forward()
