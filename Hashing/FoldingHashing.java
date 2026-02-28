// File Name: FoldingHashing.java

public class FoldingHashing {

    static final int TABLE_SIZE = 10;

    static int hashFunction(long key) {
        int sum = 0;

        while (key > 0) {
            sum += key % 100;   // taking 2-digit parts
            key = key / 100;
        }

        return sum % TABLE_SIZE;
    }

    public static void main(String[] args) {

        long[] keys = {12345678L, 98765432L, 45678912L};

        System.out.println("Folding Method Hashing");
        System.out.println("Table Size = " + TABLE_SIZE + "\n");

        for (long key : keys) {
            int index = hashFunction(key);
            System.out.println("Key: " + key + " -> Hash Index: " + index);
        }
    }
}
