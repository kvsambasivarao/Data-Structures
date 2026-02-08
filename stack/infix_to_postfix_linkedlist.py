# File Name: infix_to_postfix_ll.py

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Stack:
    def __init__(self):
        self.top = None

    def push(self, ch):
        new_node = Node(ch)
        new_node.next = self.top
        self.top = new_node

    def pop(self):
        if self.top is None:
            return None
        ch = self.top.data
        self.top = self.top.next
        return ch

    def peek(self):
        if self.top is None:
            return None
        return self.top.data

    def is_empty(self):
        return self.top is None

def precedence(ch):
    if ch in ['+', '-']:
        return 1
    if ch in ['*', '/']:
        return 2
    return 0

infix = input("Enter infix expression: ")
stack = Stack()
postfix = ""

for ch in infix:
    if ch.isalnum():
        postfix += ch
    elif ch == '(':
        stack.push(ch)
    elif ch == ')':
        while stack.peek() != '(':
            postfix += stack.pop()
        stack.pop()
    else:
        while (not stack.is_empty()) and precedence(stack.peek()) >= precedence(ch):
            postfix += stack.pop()
        stack.push(ch)

while not stack.is_empty():
    postfix += stack.pop()

print("Postfix Expression:", postfix)
