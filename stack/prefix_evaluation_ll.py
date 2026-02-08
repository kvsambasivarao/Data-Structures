# File Name: prefix_evaluation_ll.py

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
prefix = input("Enter prefix expression: ")

for ch in prefix[::-1]:
    if ch.isdigit():
        stack.push(int(ch))
    else:
        op1 = stack.pop()
        op2 = stack.pop()

        if ch == '+':
            stack.push(op1 + op2)
        elif ch == '-':
            stack.push(op1 - op2)
        elif ch == '*':
            stack.push(op1 * op2)
        elif ch == '/':
            stack.push(op1 // op2)

print("Result =", stack.pop())
