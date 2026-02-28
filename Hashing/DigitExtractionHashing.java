// File Name: DigitExtractionHashing.java

public class DigitExtractionHashing {

    static final int TABLE_SIZE = 10;

    static int hashFunction(long key) {

        int digit2 = (int)((key / 10) % 10);
        int digit4 = (int)((key / 1000) % 10);
        int digit6 = (int)((key / 100000) % 10);

        int extracted = digit2 * 100 + digit4 * 10 + digit6;

        return extracted % TABLE_SIZE;
    }

    public static void main(String[] args) {

        long[] keys = {987654321L, 123456789L, 456789123L};

        System.out.println("Digit Extraction Method Hashing");
        System.out.println("Table Size = " + TABLE_SIZE + "\n");

        for (long key : keys) {
            int index = hashFunction(key);
            System.out.println("Key: " + key + " -> Hash Index: " + index);
        }
    }
}
