package src.com.stack;

import java.util.Stack;

public class ReverseStack {
    // stack reverse using recursion
    public void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int temp = stack.pop();
        reverseStack(stack);
        insertAtLast(stack, temp);
    }

    public void insertAtLast(Stack<Integer> stack, int value){
        if(stack.isEmpty()) {
            stack.push(value);
        }else{
            int temp = stack.pop();
            insertAtLast(stack, value);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i=1;i<=5;i++){
            stack.push(i*10);
        }
        new ReverseStack().reverseStack(stack);

        while (!stack.isEmpty()){
            System.out.println(stack.pop() + " ");
        }
    }
}
