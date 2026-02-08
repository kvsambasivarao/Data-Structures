MAX = 5
queue = []
rear = -1

def enqueue(item):
    global rear
    if len(queue) == MAX:
        print("Queue Overflow")
        return
    rear += 1
    queue.append(item)
    print("Inserted", item)

enqueue(10)
enqueue(20)
enqueue(30)
