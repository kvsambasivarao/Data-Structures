# File Name: msd_radix_sort.py

def msd_radix_sort(arr, exp):
    if len(arr) <= 1 or exp == 0:
        return arr

    buckets = [[] for _ in range(10)]

    for num in arr:
        digit = (num // exp) % 10
        buckets[digit].append(num)

    result = []
    for bucket in buckets:
        if bucket:
            result.extend(msd_radix_sort(bucket, exp // 10))
    return result

# Main Program
arr = [170, 45, 75, 90, 802, 24, 2, 66]

max_val = max(arr)
exp = 10 ** (len(str(max_val)) - 1)

arr = msd_radix_sort(arr, exp)

print("Sorted array:", arr)
