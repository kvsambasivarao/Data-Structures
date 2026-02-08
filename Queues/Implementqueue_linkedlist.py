# File Name: queue_linkedlist.py

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

front = None
rear = None

def enqueue(item):
    global front, rear
    new_node = Node(item)
    if rear is None:
        front = rear = new_node
    else:
        rear.next = new_node
        rear = new_node

def dequeue():
    global front, rear
    if front is None:
        print("Queue Underflow")
        return
    print("Deleted", front.data)
    front = front.next
    if front is None:
        rear = None

def display():
    if front is None:
        print("Queue is Empty")
        return
    temp = front
    while temp:
        print(temp.data, end=" ")
        temp = temp.next
    print()

enqueue(10)
enqueue(20)
enqueue(30)
display()
dequeue()
display()
