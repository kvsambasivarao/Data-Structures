# File: min_binary_heap_delete.py

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

    def delete_min(self):

        min_value = self.heap[1]

        self.heap[1] = self.heap[self.size]
        self.heap.pop()
        self.size -= 1

        i = 1

        while 2*i <= self.size:

            smallest = i

            if self.heap[2*i] < self.heap[smallest]:
                smallest = 2*i

            if 2*i+1 <= self.size and self.heap[2*i+1] < self.heap[smallest]:
                smallest = 2*i+1

            if smallest != i:
                self.heap[i], self.heap[smallest] = self.heap[smallest], self.heap[i]
                i = smallest
            else:
                break

        return min_value

    def print_heap(self):
        print(self.heap[1:])


h = MinHeap()

h.insert(20)
h.insert(15)
h.insert(30)
h.insert(5)
h.insert(10)

print("Heap before deletion:")
h.print_heap()

print("Deleted element:", h.delete_min())

print("Heap after deletion:")
h.print_heap()
