// File Name: UniversalHashing.java

public class UniversalHashing {

    static final int TABLE_SIZE = 10;
    static final int P = 101;  // prime number

    static int a = 7;
    static int b = 3;

    static int hashFunction(int key) {
        return ((a * key + b) % P) % TABLE_SIZE;
    }

    public static void main(String[] args) {

        int[] keys = {23, 45, 12, 67, 34};

        System.out.println("Universal Hashing Method");
        System.out.println("Table Size = " + TABLE_SIZE + "\n");

        for (int key : keys) {
            int index = hashFunction(key);
            System.out.println("Key: " + key + " -> Hash Index: " + index);
        }
    }
}
