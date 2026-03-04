# File: max_binary_heap_insert.py

class MaxHeap:

    def __init__(self):
        self.heap = [0]   # index 0 unused
        self.size = 0

    def insert(self, value):

        self.heap.append(value)
        self.size += 1
        i = self.size

        while i > 1 and self.heap[i] > self.heap[i//2]:
            self.heap[i], self.heap[i//2] = self.heap[i//2], self.heap[i]
            i = i // 2

    def print_heap(self):
        print(self.heap[1:])


h = MaxHeap()

h.insert(20)
h.insert(15)
h.insert(30)
h.insert(40)
h.insert(10)

print("Max Heap Elements:")
h.print_heap()
