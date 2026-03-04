# File: max_heapify.py

class MaxHeap:

    def __init__(self):
        self.heap = [0, 10, 5, 3, 2, 4]
        self.size = 5

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

    def print_heap(self):
        print(self.heap[1:])


h = MaxHeap()

print("Before Heapify:")
h.print_heap()

h.max_heapify(1)

print("After Heapify:")
h.print_heap()
