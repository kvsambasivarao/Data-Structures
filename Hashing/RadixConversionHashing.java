// File Name: RadixConversionHashing.java

public class RadixConversionHashing {

    static final int TABLE_SIZE = 10;
    static final int BASE = 13;

    static long convertToDecimal(long key) {

        long decimal = 0;
        int power = 0;

        while (key > 0) {
            int digit = (int)(key % 10);
            decimal += digit * Math.pow(BASE, power);
            key = key / 10;
            power++;
        }

        return decimal;
    }

    static int hashFunction(long key) {
        long decimalValue = convertToDecimal(key);
        return (int)(decimalValue % TABLE_SIZE);
    }

    public static void main(String[] args) {

        long[] keys = {210485L, 12345L, 45678L};

        System.out.println("Radix Conversion Method Hashing");
        System.out.println("Table Size = " + TABLE_SIZE + "\n");

        for (long key : keys) {
            int index = hashFunction(key);
            System.out.println("Key (base " + BASE + "): " +
                               key + " -> Hash Index: " + index);
        }
    }
}
