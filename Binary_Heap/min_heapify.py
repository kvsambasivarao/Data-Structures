# File: min_heapify.py

class MinHeap:

    def __init__(self):
        self.heap = [0, 10, 5, 3, 2, 4]
        self.size = 5

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

    def print_heap(self):
        print(self.heap[1:])


h = MinHeap()

print("Before Heapify:")
h.print_heap()

h.min_heapify(1)

print("After Heapify:")
h.print_heap()
