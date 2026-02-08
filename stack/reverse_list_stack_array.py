# File Name: reverse_list_stack_array.py

stack = []
n = int(input("Enter number of elements: "))

arr = []
print("Enter elements:")
for _ in range(n):
    x = int(input())
    arr.append(x)
    stack.append(x)

for i in range(n):
    arr[i] = stack.pop()

print("Reversed list:")
print(arr)
