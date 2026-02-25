# File Name: interpolation_search.py

def interpolation_search(arr, key):
    low = 0
    high = len(arr) - 1

    while low <= high and key >= arr[low] and key <= arr[high]:

        if arr[high] == arr[low]:
            break

        pos = low + ((high - low) * (key - arr[low])) // (arr[high] - arr[low])

        if arr[pos] == key:
            return pos
        elif arr[pos] < key:
            low = pos + 1
        else:
            high = pos - 1

    return -1


# Driver Code
n = int(input("Enter number of elements: "))
arr = list(map(int, input("Enter sorted elements separated by space: ").split()))
key = int(input("Enter key to search: "))

result = interpolation_search(arr, key)

if result != -1:
    print("Element found at index", result)
else:
    print("Element not found")
