// File Name: HashTableRehashing.java

import java.util.Scanner;

class HashTableRehashing {

    private Integer[] table;
    private int size;
    private int count;
    private final double LOAD_FACTOR = 0.7;

    public HashTableRehashing(int size) {
        this.size = size;
        this.count = 0;
        table = new Integer[size];
    }

    private int hashFunction(int key) {
        return key % size;
    }

    private void rehash() {
        Integer[] oldTable = table;
        size = size * 2;
        table = new Integer[size];
        count = 0;

        for (Integer key : oldTable) {
            if (key != null)
                insert(key);
        }

        System.out.println("Rehashing done. New size = " + size);
    }

    public void insert(int key) {
        if ((double)count / size > LOAD_FACTOR)
            rehash();

        int index = hashFunction(key);

        while (table[index] != null)
            index = (index + 1) % size;

        table[index] = key;
        count++;
        System.out.println("Key " + key + " inserted");
    }

    public void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < size; i++) {
            if (table[i] == null)
                System.out.println("Index " + i + " -> EMPTY");
            else
                System.out.println("Index " + i + " -> " + table[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashTableRehashing ht = new HashTableRehashing(5);

        while (true) {
            System.out.println("\n1.Insert\n2.Display\n3.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ht.insert(sc.nextInt());
                    break;
                case 2:
                    ht.display();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
