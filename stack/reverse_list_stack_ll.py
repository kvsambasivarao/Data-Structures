# File Name: reverse_list_stack_ll.py

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Stack:
    def __init__(self):
        self.top = None

    def push(self, x):
        node = Node(x)
        node.next = self.top
        self.top = node

    def pop(self):
        x = self.top.data
        self.top = self.top.next
        return x

stack = Stack()
n = int(input("Enter number of elements: "))

arr = []
print("Enter elements:")
for _ in range(n):
    x = int(input())
    arr.append(x)
    stack.push(x)

for i in range(n):
    arr[i] = stack.pop()

print("Reversed list:")
print(arr)
