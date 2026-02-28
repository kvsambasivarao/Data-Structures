// File Name: HashTableSeparateChaining.java

import java.util.LinkedList;
import java.util.Scanner;

class HashTableSeparateChaining {

    private LinkedList<Integer>[] table;
    private int size;

    // Constructor
    public HashTableSeparateChaining(int size) {
        this.size = size;
        table = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash Function
    private int hashFunction(int key) {
        return key % size;
    }

    // Insert Operation
    public void insert(int key) {
        int index = hashFunction(key);
        if (!table[index].contains(key)) {
            table[index].add(key);
            System.out.println("Key " + key + " inserted at index " + index);
        } else {
            System.out.println("Key already exists.");
        }
    }

    // Search Operation
    public void search(int key) {
        int index = hashFunction(key);
        if (table[index].contains(key)) {
            System.out.println("Key " + key + " found at index " + index);
        } else {
            System.out.println("Key not found.");
        }
    }

    // Delete Operation
    public void delete(int key) {
        int index = hashFunction(key);
        if (table[index].remove(Integer.valueOf(key))) {
            System.out.println("Key " + key + " deleted from index " + index);
        } else {
            System.out.println("Key not found.");
        }
    }

    // Display Hash Table
    public void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + " -> " + table[i]);
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of hash table: ");
        int size = sc.nextInt();

        HashTableSeparateChaining ht = new HashTableSeparateChaining(size);

        while (true) {
            System.out.println("\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    ht.insert(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter key to search: ");
                    ht.search(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter key to delete: ");
                    ht.delete(sc.nextInt());
                    break;

                case 4:
                    ht.display();
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
