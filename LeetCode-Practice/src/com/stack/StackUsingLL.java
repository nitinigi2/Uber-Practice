package src.com.stack;

public class StackUsingLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    public void push(int item) {
        if (top == null) {
            top = new Node(item);
        } else {
            Node newNode = new Node(item);
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int data = top.data;
        top = top.next;

        return data;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        StackUsingLL stackUsingLL = new StackUsingLL();
        for (int i = 1; i <= 5; i++) {
            stackUsingLL.push(i*100);
        }

        while (!stackUsingLL.isEmpty()){
            System.out.println(stackUsingLL.pop() + " ");
        }
    }
}
