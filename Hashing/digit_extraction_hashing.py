# File Name: digit_extraction_hashing.py

TABLE_SIZE = 10

def hash_function(key):

    digit2 = (key // 10) % 10
    digit4 = (key // 1000) % 10
    digit6 = (key // 100000) % 10

    extracted = digit2 * 100 + digit4 * 10 + digit6

    return extracted % TABLE_SIZE

def main():
    keys = [987654321, 123456789, 456789123]

    print("Digit Extraction Method Hashing")
    print("Table Size =", TABLE_SIZE, "\n")

    for key in keys:
        index = hash_function(key)
        print(f"Key: {key} -> Hash Index: {index}")

if __name__ == "__main__":
    main()
