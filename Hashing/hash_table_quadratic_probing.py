# File Name: hash_table_quadratic_probing.py

class HashTable:
    def __init__(self, size):
        self.size = size
        self.table = [None] * size
        self.DELETED = -999999

    def hash_function(self, key):
        return key % self.size

    def insert(self, key):
        index = self.hash_function(key)

        for i in range(self.size):
            new_index = (index + i * i) % self.size

            if self.table[new_index] is None or self.table[new_index] == self.DELETED:
                self.table[new_index] = key
                print(f"Key {key} inserted at index {new_index}")
                return

        print("Hash Table is Full")

    def search(self, key):
        index = self.hash_function(key)

        for i in range(self.size):
            new_index = (index + i * i) % self.size

            if self.table[new_index] is None:
                break

            if self.table[new_index] == key:
                print(f"Key found at index {new_index}")
                return True

        print("Key not found")
        return False

    def delete(self, key):
        index = self.hash_function(key)

        for i in range(self.size):
            new_index = (index + i * i) % self.size

            if self.table[new_index] is None:
                break

            if self.table[new_index] == key:
                self.table[new_index] = self.DELETED
                print("Key deleted")
                return

        print("Key not found")

    def display(self):
        print("\nHash Table:")
        for i in range(self.size):
            if self.table[i] is None:
                print(f"Index {i} -> EMPTY")
            elif self.table[i] == self.DELETED:
                print(f"Index {i} -> DELETED")
            else:
                print(f"Index {i} -> {self.table[i]}")


if __name__ == "__main__":
    size = int(input("Enter size: "))
    ht = HashTable(size)

    while True:
        print("\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Exit")
        choice = int(input("Enter choice: "))

        if choice == 1:
            ht.insert(int(input("Enter key: ")))
        elif choice == 2:
            ht.search(int(input("Enter key: ")))
        elif choice == 3:
            ht.delete(int(input("Enter key: ")))
        elif choice == 4:
            ht.display()
        elif choice == 5:
            break
