import java.util.Arrays;

class ListADT {
    private int[] elements;
    private int size;

    public ListADT(int capacity) {
        elements = new int[capacity];
        size = 0;
    }

    // Insert element at the head
    public void insertAtHead(int element) {
        if (size == elements.length) {
            System.out.println("List is full");
            return;
        }
        for (int i = size - 1; i >= 0; i--) {
            elements[i + 1] = elements[i];
        }
        elements[0] = element;
        size++;
    }

    // Print the list
    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListADT list = new ListADT(10);

        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtHead(30);

        list.printList();
    }
}
