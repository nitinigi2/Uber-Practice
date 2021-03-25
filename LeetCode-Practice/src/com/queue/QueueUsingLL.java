package src.com.queue;

public class QueueUsingLL {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;

    public QueueUsingLL() {
        front = null;
        rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = newNode;
            rear = front;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
    }

    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        int data = front.data;
        front = front.next;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getFront() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        return front.data;
    }
}

class Test {
    public static void main(String[] args) {
        QueueUsingLL queue = new QueueUsingLL();
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }

        System.out.println("Queue is empty: " + queue.isEmpty());
        System.out.println("Queue front: " + queue.getFront());
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue() + " ");
        }
    }
}
