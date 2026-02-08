def precedence(ch):
    if ch == '+' or ch == '-':
        return 1
    if ch == '*' or ch == '/':
        return 2
    if ch == '^':
        return 3
    return 0

stack = []
postfix = ""

infix = input("Enter infix expression: ")

for ch in infix:
    if ch.isalnum():
        postfix += ch
    elif ch == '(':
        stack.append(ch)
    elif ch == ')':
        while stack and stack[-1] != '(':
            postfix += stack.pop()
        stack.pop()  # remove '('
    else:
        while stack and precedence(stack[-1]) >= precedence(ch):
            postfix += stack.pop()
        stack.append(ch)

while stack:
    postfix += stack.pop()

print("Postfix expression:", postfix)
