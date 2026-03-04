# File: increase_key_max_heap.py

class MaxHeap:

    def __init__(self):
        self.heap = [0]
        self.size = 0

    def insert(self, value):

        self.heap.append(value)
        self.size += 1
        i = self.size

        while i > 1 and self.heap[i] > self.heap[i//2]:
            self.heap[i], self.heap[i//2] = self.heap[i//2], self.heap[i]
            i = i // 2

    def increase_key(self, i, new_value):

        if new_value < self.heap[i]:
            print("New value is smaller than current value")
            return

        self.heap[i] = new_value

        while i > 1 and self.heap[i] > self.heap[i//2]:
            self.heap[i], self.heap[i//2] = self.heap[i//2], self.heap[i]
            i = i // 2

    def print_heap(self):
        print(self.heap[1:])


h = MaxHeap()

h.insert(20)
h.insert(15)
h.insert(30)
h.insert(10)
h.insert(40)

print("Heap before Increase-Key:")
h.print_heap()

h.increase_key(4, 35)

print("Heap after Increase-Key:")
h.print_heap()
