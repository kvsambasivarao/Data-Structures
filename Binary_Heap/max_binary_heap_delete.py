# File: max_binary_heap_delete.py

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

    def delete_max(self):

        max_value = self.heap[1]

        self.heap[1] = self.heap[self.size]
        self.heap.pop()
        self.size -= 1

        i = 1

        while 2*i <= self.size:

            largest = i

            if self.heap[2*i] > self.heap[largest]:
                largest = 2*i

            if 2*i+1 <= self.size and self.heap[2*i+1] > self.heap[largest]:
                largest = 2*i+1

            if largest != i:
                self.heap[i], self.heap[largest] = self.heap[largest], self.heap[i]
                i = largest
            else:
                break

        return max_value

    def print_heap(self):
        print(self.heap[1:])


h = MaxHeap()

h.insert(20)
h.insert(15)
h.insert(30)
h.insert(40)
h.insert(10)

print("Heap before deletion:")
h.print_heap()

print("Deleted element:", h.delete_max())

print("Heap after deletion:")
h.print_heap()
