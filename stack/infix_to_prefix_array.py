# File Name: infix_to_prefix_array.py

def precedence(ch):
    if ch in ['+', '-']:
        return 1
    if ch in ['*', '/']:
        return 2
    return 0

stack = []
infix = input("Enter infix expression: ")

# Reverse and swap parentheses
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
        stack.append(ch)
    elif ch == ')':
        while stack[-1] != '(':
            postfix += stack.pop()
        stack.pop()
    else:
        while stack and precedence(stack[-1]) >= precedence(ch):
            postfix += stack.pop()
        stack.append(ch)

while stack:
    postfix += stack.pop()

prefix = postfix[::-1]
print("Prefix Expression:", prefix)
