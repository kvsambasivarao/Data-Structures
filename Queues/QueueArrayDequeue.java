class QueueArrayDequeue
{
    int front = 0, rear = 2;
    int queue[] = {10, 20, 30};

    void dequeue()
    {
        if (front > rear)
        {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println("Deleted " + queue[front]);
        front++;
    }

    public static void main(String[] args)
    {
        QueueArrayDequeue q = new QueueArrayDequeue();
        q.dequeue();
        q.dequeue();
    }
}
