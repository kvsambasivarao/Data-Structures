# File Name: random_hashing.py

import random

TABLE_SIZE = 10

def hash_function(key):
    random.seed(key)           # Seed with key
    return random.randint(0, TABLE_SIZE - 1)

def main():
    keys = [23, 45, 12, 67, 34]

    print("Random Number Based Hashing")
    print("Table Size =", TABLE_SIZE, "\n")

    for key in keys:
        index = hash_function(key)
        print(f"Key: {key} -> Hash Index: {index}")

if __name__ == "__main__":
    main()
