# File: extract_max_heap.py

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

    def max_heapify(self, i):

        largest = i
        left = 2 * i
        right = 2 * i + 1

        if left <= self.size and self.heap[left] > self.heap[largest]:
            largest = left

        if right <= self.size and self.heap[right] > self.heap[largest]:
            largest = right

        if largest != i:
            self.heap[i], self.heap[largest] = self.heap[largest], self.heap[i]
            self.max_heapify(largest)

    def extract_max(self):

        max_value = self.heap[1]

        self.heap[1] = self.heap[self.size]
        self.heap.pop()
        self.size -= 1

        self.max_heapify(1)

        return max_value

    def print_heap(self):
        print(self.heap[1:])


h = MaxHeap()

h.insert(20)
h.insert(15)
h.insert(30)
h.insert(40)
h.insert(10)

print("Max Heap before extraction:")
h.print_heap()

print("Extracted Max element:", h.extract_max())

print("Heap after extraction:")
h.print_heap()
