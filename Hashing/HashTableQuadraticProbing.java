// File Name: HashTableQuadraticProbing.java

import java.util.Scanner;

class HashTableQuadraticProbing {

    private Integer[] table;
    private int size;
    private final Integer DELETED = Integer.MIN_VALUE;

    public HashTableQuadraticProbing(int size) {
        this.size = size;
        table = new Integer[size];
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hashFunction(key);

        for (int i = 0; i < size; i++) {
            int newIndex = (index + i * i) % size;

            if (table[newIndex] == null || table[newIndex] == DELETED) {
                table[newIndex] = key;
                System.out.println("Key " + key + " inserted at index " + newIndex);
                return;
            }
        }
        System.out.println("Hash Table is Full");
    }

    public void search(int key) {
        int index = hashFunction(key);

        for (int i = 0; i < size; i++) {
            int newIndex = (index + i * i) % size;

            if (table[newIndex] == null)
                break;

            if (table[newIndex] != DELETED && table[newIndex] == key) {
                System.out.println("Key found at index " + newIndex);
                return;
            }
        }
        System.out.println("Key not found");
    }

    public void delete(int key) {
        int index = hashFunction(key);

        for (int i = 0; i < size; i++) {
            int newIndex = (index + i * i) % size;

            if (table[newIndex] == null)
                break;

            if (table[newIndex] != DELETED && table[newIndex] == key) {
                table[newIndex] = DELETED;
                System.out.println("Key deleted");
                return;
            }
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

        HashTableQuadraticProbing ht = new HashTableQuadraticProbing(size);

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
