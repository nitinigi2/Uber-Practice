package src.com.array;

public class SubSetSum {
    static boolean[][] dp = new boolean[100][100];
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int n = arr.length;
        int sum = 11;
        boolean result = isSubsetPresent(arr, n - 1, sum);
        System.out.println(result);
    }

    private static boolean isSubsetPresent(int[] arr, int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n < 0) return false;
        if(dp[n][sum])
        if (arr[n] <= sum) {
            return dp[n][sum] = isSubsetPresent(arr, n - 1, sum - arr[n]) || isSubsetPresent(arr, n - 1, sum);
        }

        return dp[n][sum] = isSubsetPresent(arr, n - 1, sum);
    }
}
