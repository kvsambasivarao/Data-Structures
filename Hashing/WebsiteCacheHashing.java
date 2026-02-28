// File Name: WebsiteCacheHashing.java

import java.util.Scanner;

class WebsiteCacheHashing {

    static class CacheEntry {
        String url;
        String content;

        CacheEntry(String url, String content) {
            this.url = url;
            this.content = content;
        }
    }

    private CacheEntry[] cache;
    private int size;

    public WebsiteCacheHashing(int size) {
        this.size = size;
        cache = new CacheEntry[size];
    }

    private int hashFunction(String url) {
        int sum = 0;
        for (char c : url.toCharArray())
            sum += c;
        return sum % size;
    }

    public void accessWebsite(String url) {
        int index = hashFunction(url);
        int start = index;

        while (cache[index] != null) {
            if (cache[index].url.equals(url)) {
                System.out.println("Cache HIT: " + url);
                System.out.println("Content: " + cache[index].content);
                return;
            }
            index = (index + 1) % size;
            if (index == start)
                break;
        }

        System.out.println("Cache MISS: Fetching from server...");
        cache[index] = new CacheEntry(url, "HTML data of " + url);
        System.out.println("Stored in cache.");
    }

    public void display() {
        System.out.println("\nCache Table:");
        for (int i = 0; i < size; i++) {
            if (cache[i] == null)
                System.out.println("Index " + i + " -> EMPTY");
            else
                System.out.println("Index " + i + " -> " + cache[i].url);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WebsiteCacheHashing cache = new WebsiteCacheHashing(10);

        while (true) {
            System.out.println("\n1.Access Website\n2.Display Cache\n3.Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter URL: ");
                    String url = sc.nextLine();
                    cache.accessWebsite(url);
                    break;
                case 2:
                    cache.display();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
