# File Name: multiplication_hashing.py

TABLE_SIZE = 10
A = 0.618033

def hash_function(key):
    fractional = (key * A) % 1
    return int(TABLE_SIZE * fractional)

def main():
    keys = [23, 45, 12, 67, 34]

    print("Multiplication Method Hashing")
    print("Table Size =", TABLE_SIZE, "\n")

    for key in keys:
        index = hash_function(key)
        print(f"Key: {key} -> Hash Index: {index}")

if __name__ == "__main__":
    main()
