# File Name: hash_table_linear_probing.py

class HashTable:
    def __init__(self, size):
        self.size = size
        self.table = [None] * size
        self.DELETED = -999999

    def hash_function(self, key):
        return key % self.size

    def insert(self, key):
        index = self.hash_function(key)
        start_index = index

        while self.table[index] is not None and self.table[index] != self.DELETED:
            index = (index + 1) % self.size
            if index == start_index:
                print("Hash Table is Full")
                return

        self.table[index] = key
        print(f"Key {key} inserted at index {index}")

    def search(self, key):
        index = self.hash_function(key)
        start_index = index

        while self.table[index] is not None:
            if self.table[index] == key:
                print(f"Key found at index {index}")
                return True
            index = (index + 1) % self.size
            if index == start_index:
                break

        print("Key not found")
        return False

    def delete(self, key):
        index = self.hash_function(key)
        start_index = index

        while self.table[index] is not None:
            if self.table[index] == key:
                self.table[index] = self.DELETED
                print("Key deleted")
                return
            index = (index + 1) % self.size
            if index == start_index:
                break

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
