# File Name: queue_array.py

MAX = 5
queue = []
front = 0

def enqueue(item):
    if len(queue) == MAX:
        print("Queue Overflow")
        return
    queue.append(item)

def dequeue():
    global front
    if front >= len(queue):
        print("Queue Underflow")
        return
    print("Deleted", queue[front])
    front += 1

def display():
    if front >= len(queue):
        print("Queue is Empty")
        return
    for i in range(front, len(queue)):
        print(queue[i], end=" ")
    print()

enqueue(10)
enqueue(20)
enqueue(30)
display()
dequeue()
display()
