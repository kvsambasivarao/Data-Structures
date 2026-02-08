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
        {
            front = rear = newNode;
        }
        else
        {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Inserted " + item);
    }

    public static void main(String[] args)
    {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
    }
}
