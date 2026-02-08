# File Name: prefix_evaluation_array.py

stack = []
prefix = input("Enter prefix expression: ")

for ch in prefix[::-1]:
    if ch.isdigit():
        stack.append(int(ch))
    else:
        op1 = stack.pop()
        op2 = stack.pop()

        if ch == '+':
            stack.append(op1 + op2)
        elif ch == '-':
            stack.append(op1 - op2)
        elif ch == '*':
            stack.append(op1 * op2)
        elif ch == '/':
            stack.append(op1 // op2)

print("Result =", stack.pop())
