// File Name: HashingCacheApplication.java

import java.util.Scanner;

class HashingCacheApplication {

    static class CacheEntry {
        Integer key;
        Long value;

        CacheEntry(Integer key, Long value) {
            this.key = key;
            this.value = value;
        }
    }

    private CacheEntry[] cache;
    private int size = 10;

    public HashingCacheApplication() {
        cache = new CacheEntry[size];
    }

    private int hashFunction(int key) {
        return key % size;
    }

    private long factorial(int n) {
        long result = 1;
        for(int i = 1; i <= n; i++)
            result *= i;
        return result;
    }

    public long getFactorial(int n) {
        int index = hashFunction(n);
        int start = index;

        while (cache[index] != null) {
            if (cache[index].key == n) {
                System.out.println("Cache HIT for " + n);
                return cache[index].value;
            }
            index = (index + 1) % size;
            if (index == start)
                break;
        }

        System.out.println("Cache MISS for " + n + ". Computing...");
        long result = factorial(n);
        cache[index] = new CacheEntry(n, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashingCacheApplication app = new HashingCacheApplication();

        while (true) {
            System.out.println("\n1.Compute Factorial\n2.Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter number: ");
                int n = sc.nextInt();
                System.out.println("Result = " + app.getFactorial(n));
            } else {
                break;
            }
        }
    }
}
