// File Name: DivisionHashing.java

public class DivisionHashing {

    static final int TABLE_SIZE = 10;

    static int hashFunction(int key) {
        return key % TABLE_SIZE;
    }

    public static void main(String[] args) {

        int[] keys = {23, 45, 12, 67, 34};

        System.out.println("Division Method Hashing");
        System.out.println("Table Size = " + TABLE_SIZE + "\n");

        for (int key : keys) {
            int index = hashFunction(key);
            System.out.println("Key: " + key + " -> Hash Index: " + index);
        }
    }
}
