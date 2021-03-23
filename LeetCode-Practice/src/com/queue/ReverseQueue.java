package src.com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {


    public static void reverseQueue(Queue<Integer> queue) {
        if(queue.isEmpty()) return;
        int temp = queue.poll();
        reverseQueue(queue);
        queue.add(temp);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=5;i++){
            queue.add(i);
        }

        reverseQueue(queue);

        while (!queue.isEmpty()){
            System.out.println(queue.poll() + " ");
        }
    }
}
