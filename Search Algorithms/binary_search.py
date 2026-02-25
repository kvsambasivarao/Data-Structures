# File Name: binary_search.py

def binary_search(arr, key):
    low = 0
    high = len(arr) - 1

    while low <= high:
        mid = (low + high) // 2

        if arr[mid] == key:
            return mid
        elif arr[mid] < key:
            low = mid + 1
        else:
            high = mid - 1

    return -1


# Driver Code
n = int(input("Enter number of elements: "))
arr = list(map(int, input("Enter sorted elements separated by space: ").split()))
key = int(input("Enter key to search: "))

result = binary_search(arr, key)

if result != -1:
    print("Element found at index", result)
else:
    print("Element not found")
