package src.com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortPath {
    // Left, right, Up, Down directions
    private static int[] R = {0, 0, 1, -1};
    private static int[] C = {-1, 1, 0, 0};

    public static void main(String[] args) {
        int[][] arr = {
                {1,1}
        };
        //for (int i = 0; i < 5; i++) {
            int[][] grid = MatrixGenerator.generateMatrix();
            printMatrix(grid);
            int ans = shortestPathBinaryMatrix(grid);
            System.out.println(ans);
        //}

    }

    public static void printMatrix(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        System.out.println("n: " + n + " m: " + m);

        if (grid[0][0] == 0 || grid[n - 1][m - 1] == 0) {
            return -1;
        }

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                if (pair.x == n - 1 && pair.y == m - 1) {
                    return ans + 1;
                }

                for (int k = 0; k < 4; k++) {
                    int nextX = R[k] + pair.x;
                    int nextY = C[k] + pair.y;

                    if (!isValid(nextX, nextY, n, m)) continue;

                    if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                        queue.add(new Pair(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }

                }
            }
            ans++;
        }

        return -1;
    }

    public static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
