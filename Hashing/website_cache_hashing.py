# File Name: website_cache_hashing.py

class WebsiteCache:
    def __init__(self, size=10):
        self.size = size
        self.cache = [None] * size

    def hash_function(self, url):
        return sum(ord(c) for c in url) % self.size

    def access_website(self, url):
        index = self.hash_function(url)
        start = index

        while self.cache[index] is not None:
            if self.cache[index]["url"] == url:
                print(f"Cache HIT: {url}")
                print(f"Content: {self.cache[index]['content']}")
                return
            index = (index + 1) % self.size
            if index == start:
                break

        print("Cache MISS: Fetching from server...")
        self.cache[index] = {
            "url": url,
            "content": f"HTML data of {url}"
        }
        print("Stored in cache.")

    def display(self):
        print("\nCache Table:")
        for i in range(self.size):
            if self.cache[i] is None:
                print(f"Index {i} -> EMPTY")
            else:
                print(f"Index {i} -> {self.cache[i]['url']}")


if __name__ == "__main__":
    cache = WebsiteCache()

    while True:
        print("\n1.Access Website\n2.Display Cache\n3.Exit")
        choice = int(input("Enter choice: "))

        if choice == 1:
            url = input("Enter URL: ")
            cache.access_website(url)
        elif choice == 2:
            cache.display()
        elif choice == 3:
            break
