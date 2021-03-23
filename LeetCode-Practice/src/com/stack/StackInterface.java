package src.com.stack;

public interface StackInterface<E> {
    void push(E item);
    E pop();
    E peek();
    boolean isEmpty();
}
