"""
File Name: update_array_elements.py
Description: Program to demonstrate updating elements in an array (list)
Language: Python
"""

# Declare and initialize a list (array)
arr = [1, 2, 3, 4, 5]

# Print the original array
print("Original array:", end=" ")
for element in arr:
    print(element, end=" ")
print()

# Calculate the sum of array elements
total = 0
for element in arr:
    total += element

# Print the sum
print("Sum of array elements:", total)

# Update each element by doubling its value
for i in range(len(arr)):
    arr[i] = arr[i] * 2

# Print the updated array
print("Updated array:", end=" ")
for element in arr:
    print(element, end=" ")
print()
