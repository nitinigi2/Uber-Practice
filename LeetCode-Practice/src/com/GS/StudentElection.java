package src.com.GS;

import java.util.*;

public class StudentElection {

    public static int whoIsElected(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size()!=1){
            int count=k;
            while (count != 1) {
                queue.add(queue.remove());
                count--;
            }
            queue.remove();
        }
        return queue.remove();
    }

    public static void main(String[] args) {
        int n = 1, k=1;
        int ans = whoIsElected(n, k);
        System.out.println(ans);
    }
}

