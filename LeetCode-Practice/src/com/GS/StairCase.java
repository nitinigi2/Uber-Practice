package src.com.GS;

import java.util.Arrays;

public class StairCase {

    private static int[] dp;
    public static int countSteps(int steps) {
        if (steps == 0 || steps == 1) {
            return 1;
        }
        if (steps == 2) {
            return 2;
        }
        if(dp[steps] != -1) {
            return dp[steps];
        }
        return dp[steps] = countSteps(steps - 3) + countSteps(steps - 2) + countSteps(steps - 1);
    }

    public static void main(String[] args) {
        int n = 3;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(countSteps(n));
    }

}
