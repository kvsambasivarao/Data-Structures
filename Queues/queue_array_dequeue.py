queue = [10, 20, 30]
front = 0
rear = len(queue) - 1

def dequeue():
    global front
    if front > rear:
        print("Queue Underflow")
        return
    print("Deleted", queue[front])
    front += 1

dequeue()
dequeue()
