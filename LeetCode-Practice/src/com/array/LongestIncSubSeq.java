package src.com.array;

import java.lang.reflect.Array;
import java.util.*;

public class LongestIncSubSeq {
/*  Given n elements, write a program that prints the longest increasing subsequence whose adjacent element difference is one.

    Input : a[] = {3, 10, 3, 11, 4, 5, 6, 7, 8, 12}
    Output : 3 4 5 6 7 8
    Explanation: 3, 4, 5, 6, 7, 8 is the longest increasing subsequence whose adjacent element differs by one.

            Input : a[] = {6, 7, 8, 3, 4, 5, 9, 10}
    Output : 6 7 8 9 10
    Explanation: 6, 7, 8, 9, 10 is the longest increasing subsequence*/

    public static List<Integer> findLongestIncSubSeq(int[] arr, int n) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }

        int start = 0, end = 0;
        int maxDist = 0;

        for (int i = 0; i < n; i++) {
            if (!set.contains(arr[i])) continue;
            int index = 0;
            while (set.contains(arr[i] - 1)) {
                index--;
            }
            int startingValue = arr[i] + index;
            int endingValue = startingValue;
            while (set.contains(endingValue + 1)) {
                set.remove(endingValue);
                endingValue++;
            }
            if (endingValue - startingValue > maxDist) {
                maxDist = endingValue - startingValue;
                start = startingValue;
                end = endingValue;
            }
        }

        for (int i = start; i <= end; i++) {
            ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {3, 10, 3, 11, 4,
                5, 6, 7, 8, 12};
        int n = a.length;

        System.out.println(findLongestIncSubSeq(a, n));
    }
}
