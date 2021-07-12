package src.com.GS;

public class OptimalPath {

    private static int[][] dp = new int[1001][1001];

    private static int optimalPath(int[][] paths, int r, int c) {
        if (!isValid(r, c, paths.length, paths[0].length)) {
            return Integer.MIN_VALUE;
        }
        if (r == 0 && c == paths[0].length - 1) {
            return paths[r][c];
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        return dp[r][c] = Math.max(optimalPath(paths, r - 1, c), optimalPath(paths, r, c + 1)) + paths[r][c];
    }

    private static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public static void main(String[] args) {
        int[][] paths = {
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}
        };

        for(int i=0;i<1000;i++){
            for(int j=0;j<1000;j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(optimalPath(paths, paths.length - 1, 0));
    }
}
