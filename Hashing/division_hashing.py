# File Name: division_hashing.py

TABLE_SIZE = 10

def hash_function(key):
    return key % TABLE_SIZE

def main():
    keys = [23, 45, 12, 67, 34]

    print("Division Method Hashing")
    print("Table Size =", TABLE_SIZE, "\n")

    for key in keys:
        index = hash_function(key)
        print(f"Key: {key} -> Hash Index: {index}")

if __name__ == "__main__":
    main()
