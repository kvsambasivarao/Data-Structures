# File Name: radix_conversion_hashing.py

TABLE_SIZE = 10
BASE = 13

def convert_to_decimal(key):
    decimal = 0
    power = 0

    while key > 0:
        digit = key % 10
        decimal += digit * (BASE ** power)
        key //= 10
        power += 1

    return decimal

def hash_function(key):
    decimal_value = convert_to_decimal(key)
    return decimal_value % TABLE_SIZE

def main():
    keys = [210485, 12345, 45678]

    print("Radix Conversion Method Hashing")
    print("Table Size =", TABLE_SIZE, "\n")

    for key in keys:
        index = hash_function(key)
        print(f"Key (base {BASE}): {key} -> Hash Index: {index}")

if __name__ == "__main__":
    main()
