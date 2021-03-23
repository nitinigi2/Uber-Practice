package src.com.queue;

import java.sql.SQLOutput;

public class QueueUsingArray<E> implements QueueInterface<E> {
    private int MAX = 5;
    private int front;
    private int rear;
    private Object[] arr;

    public QueueUsingArray() {
        this.front = -1;
        this.rear = -1;
        arr = new Object[MAX];
    }

    @Override
    public void enqueue(E item) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        if (front == -1 && rear == -1) {
            front++;
            rear++;
            arr[rear] = item;
        } else {
            arr[++rear] = item;
        }
    }

    public boolean isFull() {
        return rear == MAX - 1;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        E removedElement = (E) arr[front];
        //System.out.println("Rear: " + arr[rear]);
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        arr[rear] = 0;
        if (front == rear) {
            front = -1;
        }
        rear--;

        return removedElement;
    }

    @Override
    public E front() {
        if (isEmpty()) {
            return null;
        }
        return (E) arr[front];
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    public static void main(String[] args) {
        QueueInterface<Integer> queue = new QueueUsingArray<>();
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i * 10);
        }

        System.out.println("Queue front value: " + queue.front());

        System.out.println("Queue is empty: " + queue.isEmpty());

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue() + " ");
        }
    }
}
