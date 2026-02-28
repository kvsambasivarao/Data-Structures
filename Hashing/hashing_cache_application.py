# File Name: hashing_cache_application.py

class HashingCacheApplication:
    def __init__(self, size=10):
        self.size = size
        self.cache = [None] * size

    def hash_function(self, key):
        return key % self.size

    def factorial(self, n):
        result = 1
        for i in range(1, n + 1):
            result *= i
        return result

    def get_factorial(self, n):
        index = self.hash_function(n)
        start = index

        while self.cache[index] is not None:
            if self.cache[index]["key"] == n:
                print(f"Cache HIT for {n}")
                return self.cache[index]["value"]
            index = (index + 1) % self.size
            if index == start:
                break

        print(f"Cache MISS for {n}. Computing...")
        result = self.factorial(n)
        self.cache[index] = {"key": n, "value": result}
        return result


if __name__ == "__main__":
    app = HashingCacheApplication()

    while True:
        print("\n1.Compute Factorial\n2.Exit")
        choice = int(input("Enter choice: "))

        if choice == 1:
            n = int(input("Enter number: "))
            print("Result =", app.get_factorial(n))
        else:
            break
