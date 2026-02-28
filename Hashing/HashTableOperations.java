// File Name: HashTableOperations.java

import java.util.Scanner;

class HashTableOperations {

    private Integer[] table;
    private int size;
    private final Integer DELETED = Integer.MIN_VALUE;

    public HashTableOperations(int size) {
        this.size = size;
        table = new Integer[size];
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hashFunction(key);
        int start = index;

        while (table[index] != null && table[index] != DELETED) {
            index = (index + 1) % size;
            if (index == start) {
                System.out.println("Hash Table is Full");
                return;
            }
        }

        table[index] = key;
        System.out.println("Key inserted at index " + index);
    }

    public void search(int key) {
        int index = hashFunction(key);
        int start = index;

        while (table[index] != null) {
            if (table[index] != DELETED && table[index] == key) {
                System.out.println("Key found at index " + index);
                return;
            }
            index = (index + 1) % size;
            if (index == start)
                break;
        }

        System.out.println("Key not found");
    }

    public void delete(int key) {
        int index = hashFunction(key);
        int start = index;

        while (table[index] != null) {
            if (table[index] != DELETED && table[index] == key) {
                table[index] = DELETED;
                System.out.println("Key deleted");
                return;
            }
            index = (index + 1) % size;
            if (index == start)
                break;
        }

        System.out.println("Key not found");
    }

    public void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < size; i++) {
            if (table[i] == null)
                System.out.println("Index " + i + " -> EMPTY");
            else if (table[i] == DELETED)
                System.out.println("Index " + i + " -> DELETED");
            else
                System.out.println("Index " + i + " -> " + table[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        HashTableOperations ht = new HashTableOperations(size);

        while (true) {
            System.out.println("\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ht.insert(sc.nextInt());
                    break;
                case 2:
                    ht.search(sc.nextInt());
                    break;
                case 3:
                    ht.delete(sc.nextInt());
                    break;
                case 4:
                    ht.display();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
