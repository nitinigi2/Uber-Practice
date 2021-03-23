package src.com.queue;

public interface QueueInterface<E> {
    void enqueue(E item);
    E dequeue();
    E front();
    boolean isEmpty();
}
