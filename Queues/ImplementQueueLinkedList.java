/* File Name: QueueLinkedList.java */

class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class QueueLinkedList
{
    Node front = null, rear = null;

    void enqueue(int item)
    {
        Node newNode = new Node(item);
        if (rear == null)
            front = rear = newNode;
        else
        {
            rear.next = newNode;
            rear = newNode;
        }
    }

    void dequeue()
    {
        if (front == null)
        {
            System.out.println("Queue Underflow");
            return;
        }
        System.out.println("Deleted " + front.data);
        front = front.next;
        if (front == null)
            rear = null;
    }

    void display()
    {
        if (front == null)
        {
            System.out.println("Queue is Empty");
            return;
        }
        Node temp = front;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.dequeue();
        q.display();
    }
}
