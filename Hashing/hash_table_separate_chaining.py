# File Name: hash_table_separate_chaining.py

class HashTable:
    def __init__(self, size):
        self.size = size
        self.table = [[] for _ in range(size)]   # Create empty chains

    # Hash Function (Division Method)
    def hash_function(self, key):
        return key % self.size

    # Insert Operation
    def insert(self, key):
        index = self.hash_function(key)
        chain = self.table[index]

        if key not in chain:
            chain.append(key)
            print(f"Key {key} inserted at index {index}.")
        else:
            print(f"Key {key} already exists.")

    # Search Operation
    def search(self, key):
        index = self.hash_function(key)
        chain = self.table[index]

        if key in chain:
            print(f"Key {key} found at index {index}.")
            return True
        else:
            print(f"Key {key} not found.")
            return False

    # Delete Operation
    def delete(self, key):
        index = self.hash_function(key)
        chain = self.table[index]

        if key in chain:
            chain.remove(key)
            print(f"Key {key} deleted from index {index}.")
        else:
            print(f"Key {key} not found. Cannot delete.")

    # Display Hash Table
    def display(self):
        print("\nHash Table:")
        for i in range(self.size):
            print(f"Index {i} -> {self.table[i]}")


# ------------------ Main Program ------------------

if __name__ == "__main__":
    size = int(input("Enter size of hash table: "))
    ht = HashTable(size)

    while True:
        print("\n1. Insert")
        print("2. Search")
        print("3. Delete")
        print("4. Display")
        print("5. Exit")

        choice = int(input("Enter your choice: "))

        if choice == 1:
            key = int(input("Enter key to insert: "))
            ht.insert(key)

        elif choice == 2:
            key = int(input("Enter key to search: "))
            ht.search(key)

        elif choice == 3:
            key = int(input("Enter key to delete: "))
            ht.delete(key)

        elif choice == 4:
            ht.display()

        elif choice == 5:
            print("Exiting program.")
            break

        else:
            print("Invalid choice. Please try again.")
