# File: decrease_key_max_heap.py

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

    def decrease_key(self, i, new_value):

        if new_value > self.heap[i]:
            print("New value is greater than current value")
            return

        self.heap[i] = new_value

        self.max_heapify(i)

    def print_heap(self):
        print(self.heap[1:])


h = MaxHeap()

h.insert(50)
h.insert(40)
h.insert(45)
h.insert(30)
h.insert(35)

print("Heap before Decrease-Key:")
h.print_heap()

h.decrease_key(1, 25)

print("Heap after Decrease-Key:")
h.print_heap()
