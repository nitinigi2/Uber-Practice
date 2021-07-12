package src.com.GS;

import java.util.Map;

public class SubarrayExceedingSum {
    public static int subArrayExceedsSum(int arr[], int target) {
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0, n = arr.length;
        int currSum = 0;
        while (j < n) {
            if (arr[j] >= target) {
                return 1;
            }
            while (currSum <= target && j < n) {
                currSum += arr[j++];
            }
            while (currSum > target && i < n) {
                min = Math.min(min, j - i);
                currSum -= arr[i++];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = -1;
        int ans = subArrayExceedsSum(arr, k);
        System.out.println(ans);
    }
}
