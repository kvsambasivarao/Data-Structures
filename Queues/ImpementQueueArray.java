/* File Name: QueueArray.java */
class QueueArray
{
    int MAX = 5;
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
    }

    void dequeue()
    {
        if (front == -1 || front > rear)
        {
            System.out.println("Queue Underflow");
            return;
        }
        System.out.println("Deleted " + queue[front++]);
    }

    void display()
    {
        if (front == -1 || front > rear)
        {
            System.out.println("Queue is Empty");
            return;
        }
        for (int i = front; i <= rear; i++)
            System.out.print(queue[i] + " ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        QueueArray q = new QueueArray();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.dequeue();
        q.display();
    }
}
