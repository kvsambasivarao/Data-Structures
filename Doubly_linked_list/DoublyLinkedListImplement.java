// File Name: DoublyLinkedList.java
// Program to implement a doubly linked list

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    static Node head = null;

    static void insertBeg(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
    }

    static void insertEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    static void deleteBeg() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        if (head != null)
            head.prev = null;
    }

    static void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.prev.next = null;
    }

    static void traverseForward() {
        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    static void traverseBackward() {
        Node temp = head;
        if (temp == null)
            return;
        while (temp.next != null)
            temp = temp.next;
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        insertBeg(10);
        insertEnd(20);
        insertEnd(30);

        traverseForward();
        traverseBackward();

        deleteBeg();
        deleteEnd();

        traverseForward();
    }
}
