class QueueArray
{
    static final int MAX = 5;
    int front = -1, rear = -1;
    int queue[] = new int[MAX];

    void enqueue(int item)
    {
        if (rear == MAX - 1)
        {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1)
            front = 0;

        queue[++rear] = item;
        System.out.println("Inserted " + item);
    }

    public static void main(String[] args)
    {
        QueueArray q = new QueueArray();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
    }
}
