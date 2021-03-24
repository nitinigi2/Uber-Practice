package src.com.stack;

import java.util.Stack;

public class SortStack {
    public Stack<Integer> sort(Stack<Integer> s){
        Stack<Integer> temp = new Stack<>();
        while(!s.isEmpty()){
            int top = s.pop();
            while(!temp.isEmpty() && top > temp.peek()){
                s.push(temp.pop());
            }
            temp.push(top);
        }
        return temp;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);

        Stack<Integer> reversedStack = new SortStack().sort(stack);

        while (!reversedStack.isEmpty()){
            System.out.println(reversedStack.pop() + " ");
        }
    }
}
