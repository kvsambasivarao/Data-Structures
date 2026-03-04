# File: extract_min_heap.py

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

    def extract_min(self):

        min_value = self.heap[1]

        self.heap[1] = self.heap[self.size]
        self.heap.pop()
        self.size -= 1

        self.min_heapify(1)

        return min_value

    def print_heap(self):
        print(self.heap[1:])


h = MinHeap()

h.insert(20)
h.insert(15)
h.insert(30)
h.insert(5)
h.insert(10)

print("Min Heap before extraction:")
h.print_heap()

print("Extracted Min element:", h.extract_min())

print("Heap after extraction:")
h.print_heap()
