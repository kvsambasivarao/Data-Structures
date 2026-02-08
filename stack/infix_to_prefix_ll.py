# File Name: infix_to_prefix_ll.py

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Stack:
    def __init__(self):
        self.top = None

    def push(self, ch):
        node = Node(ch)
        node.next = self.top
        self.top = node

    def pop(self):
        ch = self.top.data
        self.top = self.top.next
        return ch

    def peek(self):
        return self.top.data

    def is_empty(self):
        return self.top is None

def precedence(ch):
    if ch in ['+', '-']:
        return 1
    if ch in ['*', '/']:
        return 2
    return 0

stack = Stack()
infix = input("Enter infix expression: ")

rev = ""
for ch in infix[::-1]:
    if ch == '(':
        rev += ')'
    elif ch == ')':
        rev += '('
    else:
        rev += ch

postfix = ""

for ch in rev:
    if ch.isalnum():
        postfix += ch
    elif ch == '(':
        stack.push(ch)
    elif ch == ')':
        while stack.peek() != '(':
            postfix += stack.pop()
        stack.pop()
    else:
        while not stack.is_empty() and precedence(stack.peek()) >= precedence(ch):
            postfix += stack.pop()
        stack.push(ch)

while not stack.is_empty():
    postfix += stack.pop()

prefix = postfix[::-1]
print("Prefix Expression:", prefix)
