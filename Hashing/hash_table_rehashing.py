# File Name: hash_table_rehashing.py

class HashTable:
    def __init__(self, size=5):
        self.size = size
        self.count = 0
        self.table = [None] * size
        self.LOAD_FACTOR = 0.7

    def hash_function(self, key):
        return key % self.size

    def rehash(self):
        old_table = self.table
        self.size *= 2
        self.table = [None] * self.size
        self.count = 0

        for key in old_table:
            if key is not None:
                self.insert(key)

        print(f"Rehashing done. New size = {self.size}")

    def insert(self, key):
        if self.count / self.size > self.LOAD_FACTOR:
            self.rehash()

        index = self.hash_function(key)

        while self.table[index] is not None:
            index = (index + 1) % self.size

        self.table[index] = key
        self.count += 1
        print(f"Key {key} inserted")

    def display(self):
        print("\nHash Table:")
        for i in range(self.size):
            if self.table[i] is None:
                print(f"Index {i} -> EMPTY")
            else:
                print(f"Index {i} -> {self.table[i]}")


if __name__ == "__main__":
    ht = HashTable()

    while True:
        print("\n1.Insert\n2.Display\n3.Exit")
        choice = int(input("Enter choice: "))

        if choice == 1:
            ht.insert(int(input("Enter key: ")))
        elif choice == 2:
            ht.display()
        elif choice == 3:
            break
