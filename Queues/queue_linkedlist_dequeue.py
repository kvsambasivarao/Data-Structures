class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

front = Node(10)
front.next = Node(20)
front.next.next = Node(30)

def dequeue():
    global front
    if front is None:
        print("Queue Underflow")
        return
    print("Deleted", front.data)
    front = front.next

dequeue()
dequeue()
