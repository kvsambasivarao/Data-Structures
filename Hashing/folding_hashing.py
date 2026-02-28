# File Name: folding_hashing.py

TABLE_SIZE = 10

def hash_function(key):
    sum_parts = 0

    while key > 0:
        sum_parts += key % 100   # taking 2-digit parts
        key = key // 100

    return sum_parts % TABLE_SIZE

def main():
    keys = [12345678, 98765432, 45678912]

    print("Folding Method Hashing")
    print("Table Size =", TABLE_SIZE, "\n")

    for key in keys:
        index = hash_function(key)
        print(f"Key: {key} -> Hash Index: {index}")

if __name__ == "__main__":
    main()
