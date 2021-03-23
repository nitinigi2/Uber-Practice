package src.com.queue;

import src.com.linklist.ReverseDoublyList;

public class QueueUsingDoublyLinkedList<E> implements QueueInterface<E> {
    public static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        public Node(E data){
            this.data = data;
        }
    }

    private Node<E> front;
    private Node<E> rear;

    @Override
    public void enqueue(E data) {
        Node newNode = new Node(data);
        if(front == null){
            front = newNode;
            rear = front;
        }else{
            rear.next = newNode;
            newNode.prev = rear;
            rear = rear.next;
        }
    }

    @Override
    public E dequeue() {
        if(front == null){
            System.out.println("Queue is empty");
            return null;
        }
        E data = front.data;
        front = front.next;

        if(front != null)
            front.prev = null;
        return data;
    }

    @Override
    public E front() {
        if(front == null) {
            System.out.println("Queue is empty");
            return null;
        }
        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    public static void main(String[] args) {
        QueueUsingDoublyLinkedList queue = new QueueUsingDoublyLinkedList();
        for(int i=1;i<=10;i++){
            queue.enqueue(i);
        }

        System.out.println("Queue is empty: " + queue.isEmpty());
        System.out.println("Front of queue: " + queue.front());
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue() + " ");
        }


    }
}
