# File Name: linear_search.py

def linear_search(arr, key):
    for i in range(len(arr)):
        if arr[i] == key:
            return i
    return -1


# Driver Code
n = int(input("Enter number of elements: "))
arr = list(map(int, input("Enter elements separated by space: ").split()))
key = int(input("Enter key to search: "))

result = linear_search(arr, key)

if result != -1:
    print("Element found at index", result)
else:
    print("Element not found")
