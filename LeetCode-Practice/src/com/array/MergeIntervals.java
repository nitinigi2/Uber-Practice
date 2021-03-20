package src.com.array;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // sorting based on start time of interval in ascending
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        Stack<Pair> stack = new Stack<>();
        for(int[] interval : intervals){
            Pair pair = new Pair(interval[0], interval[1]);
            if(stack.isEmpty()){
                stack.push(pair);
            }
            else{
                // checking with last interval if current interval can be merged
                Pair top = stack.peek();
                if(interval[0] <= top.second){
                    stack.pop();
                    stack.push(new Pair(top.first, Math.max(top.second, interval[1])));
                }else{
                    stack.push(pair);
                }
            }
        }
        //System.out.println(stack);
        int[][] ans = new int[stack.size()][2];
        int i=0;
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            ans[i] = new int[] {pair.first, pair.second};
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,4},{0,4}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] mergedIntervals = mergeIntervals.merge(intervals);
        mergeIntervals.printIntervals(mergedIntervals);

    }

    public void printIntervals(int[][] intervals){
        for(int[] interval : intervals){
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
