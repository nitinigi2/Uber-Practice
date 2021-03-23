package src.com.stack;

import java.util.Stack;

public class StackUsingArray<E> implements StackInterface<E>{
    private int MAX = 5;
    private int top;
    private Object[] arr;

    public StackUsingArray(){
        this.arr = new Object[MAX];
        this.top = -1;
    }


    @Override
    public void push(Object item) {
        if(top == MAX-1){
            throw new RuntimeException("Stack overflow");
        }
        arr[++top] = item;
    }

    @Override
    public E pop() {
        if(top == -1){
            throw new RuntimeException("Stack underflow error");
        }

        return (E) arr[top--];
    }

    @Override
    public E peek() {
        if(top == -1){
            throw new RuntimeException("Stack underflow error");
        }
        return (E) arr[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        StackInterface<String> stack = new StackUsingArray();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");

        while(!stack.isEmpty()){
            System.out.println(stack.pop() + " ");
        }

        System.out.println("Stack is empty: " + stack.isEmpty());
    }
}
