// File Name: MultiplicationHashing.java

public class MultiplicationHashing {

    static final int TABLE_SIZE = 10;
    static final double A = 0.618033;

    static int hashFunction(int key) {
        double fractional = (key * A) % 1;
        return (int)(TABLE_SIZE * fractional);
    }

    public static void main(String[] args) {

        int[] keys = {23, 45, 12, 67, 34};

        System.out.println("Multiplication Method Hashing");
        System.out.println("Table Size = " + TABLE_SIZE + "\n");

        for (int key : keys) {
            int index = hashFunction(key);
            System.out.println("Key: " + key + " -> Hash Index: " + index);
        }
    }
}
