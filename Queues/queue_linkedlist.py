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

    print("Inserted", item)

enqueue(10)
enqueue(20)
enqueue(30)
