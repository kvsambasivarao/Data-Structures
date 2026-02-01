// File Name: CircularDoublyLinkedList.java
// Program to implement a circular doubly linked list with basic operations

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class CircularDoublyLinkedList {
    static Node head = null;

    static void insertBeg(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
            return;
        }

        Node last = head.prev;
        newNode.next = head;
        newNode.prev = last;
        last.next = newNode;
        head.prev = newNode;
        head = newNode;
    }

    static void insertEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
            return;
        }

        Node last = head.prev;
        newNode.next = head;
        newNode.prev = last;
        last.next = newNode;
        head.prev = newNode;
    }

    static void deleteBeg() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node last = head.prev;
        head = head.next;
        head.prev = last;
        last.next = head;
    }

    static void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node last = head.prev;
        Node secondLast = last.prev;
        secondLast.next = head;
        head.prev = secondLast;
    }

    static void traverseForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Forward: ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("HEAD");
    }

    static void traverseBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head.prev;
        System.out.print("Backward: ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != head.prev);
        System.out.println("HEAD");
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
