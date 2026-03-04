# File: increase_key_min_heap.py

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

    def min_heapify(self, i):

        smallest = i
        left = 2 * i
        right = 2 * i + 1

        if left <= self.size and self.heap[left] < self.heap[smallest]:
            smallest = left

        if right <= self.size and self.heap[right] < self.heap[smallest]:
            smallest = right

        if smallest != i:
            self.heap[i], self.heap[smallest] = self.heap[smallest], self.heap[i]
            self.min_heapify(smallest)

    def increase_key(self, i, new_value):

        if new_value < self.heap[i]:
            print("New value is smaller than current value")
            return

        self.heap[i] = new_value

        self.min_heapify(i)

    def print_heap(self):
        print(self.heap[1:])


h = MinHeap()

h.insert(10)
h.insert(20)
h.insert(15)
h.insert(25)
h.insert(30)

print("Heap before Increase-Key:")
h.print_heap()

h.increase_key(1, 35)

print("Heap after Increase-Key:")
h.print_heap()
