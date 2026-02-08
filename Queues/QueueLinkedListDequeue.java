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

class QueueLinkedListDequeue
{
    Node front;

    void dequeue()
    {
        if (front == null)
        {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println("Deleted " + front.data);
        front = front.next;
    }

    public static void main(String[] args)
    {
        QueueLinkedListDequeue q = new QueueLinkedListDequeue();
        q.front = new Node(10);
        q.front.next = new Node(20);
        q.front.next.next = new Node(30);

        q.dequeue();
        q.dequeue();
    }
}
