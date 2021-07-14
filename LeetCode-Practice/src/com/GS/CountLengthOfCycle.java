package src.com.GS;

import java.util.HashSet;
import java.util.Set;

public class CountLengthOfCycle {

    private static int countLengthOfCycle(int[] arr, int startIndex) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(arr[startIndex])) {
            set.add(arr[startIndex]);
            startIndex = arr[startIndex];
        }
        return !set.contains(arr[startIndex]) ? -1 : set.size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0};
        int startIndex = 0;
        System.out.println(countLengthOfCycle(arr, startIndex));
    }
}
