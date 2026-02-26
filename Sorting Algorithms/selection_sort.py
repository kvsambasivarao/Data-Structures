# File Name: selection_sort.py

def selection_sort(arr):
    n = len(arr)

    for i in range(n - 1):
        min_index = i

        for j in range(i + 1, n):
            if arr[j] < arr[min_index]:
                min_index = j

        # Swap
        arr[i], arr[min_index] = arr[min_index], arr[i]

# Main Program
arr = [64, 25, 12, 22, 11]

selection_sort(arr)

print("Sorted array:", arr)
