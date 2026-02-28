# File Name: universal_hashing.py

TABLE_SIZE = 10
P = 101   # prime number

a = 7
b = 3

def hash_function(key):
    return ((a * key + b) % P) % TABLE_SIZE

def main():
    keys = [23, 45, 12, 67, 34]

    print("Universal Hashing Method")
    print("Table Size =", TABLE_SIZE, "\n")

    for key in keys:
        index = hash_function(key)
        print(f"Key: {key} -> Hash Index: {index}")

if __name__ == "__main__":
    main()
