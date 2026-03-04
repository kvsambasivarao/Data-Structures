# File: decrease_key_min_heap.py

class MinHeap:

    def __init__(self):
        self.heap = [0]
        self.size = 0

    def insert(self, value):

        self.heap.append(value)
        self.size += 1
        i = self.size

        while i > 1 and self.heap[i] < self.heap[i//2]:
            self.heap[i], self.heap[i//2] = self.heap[i//2], self.heap[i]
            i = i // 2

    def decrease_key(self, i, new_value):

        if new_value > self.heap[i]:
            print("New value is greater than current value")
            return

        self.heap[i] = new_value

        while i > 1 and self.heap[i] < self.heap[i//2]:
            self.heap[i], self.heap[i//2] = self.heap[i//2], self.heap[i]
            i = i // 2

    def print_heap(self):
        print(self.heap[1:])


h = MinHeap()

h.insert(20)
h.insert(15)
h.insert(30)
h.insert(25)
h.insert(40)

print("Heap before Decrease-Key:")
h.print_heap()

h.decrease_key(4, 10)

print("Heap after Decrease-Key:")
h.print_heap()
