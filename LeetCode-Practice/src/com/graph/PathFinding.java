package src.com.graph;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/find-minimum-numbers-moves-needed-move-one-cell-matrix-another/
public class PathFinding {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] R = {-1, 1, 0, 0};
    private static int[] C = {0, 0, 1, -1};

    public static int minimumMovesToReachEnd(int[][] arr) {
        int srcRow = 0, srcCol = 0, destRow = 0, destCol = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    srcRow = i;
                    srcCol = j;
                }

                if (arr[i][j] == 2) {
                    destRow = i;
                    destCol = j;
                }
            }
        }

        return bfs(arr, srcRow, srcCol, destRow, destCol);
    }

    private static int bfs(int[][] arr, int srcRow, int srcCol, int destRow, int destCol) {
        int n = arr.length;
        int m = arr[0].length;

        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dis[i][j] = -1;
                if(i == srcRow && j == srcCol) {
                    dis[i][j] = 0;
                }
            }
        }

        queue.add(new Pair(srcRow, srcCol));
        visited[srcRow][srcCol] = true;

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = curr.x + R[i];
                int y = curr.y + C[i];

                if (isValid(x, y, n, m) && arr[x][y] != 0 && !visited[x][y]) {
                    dis[x][y] = dis[curr.x][curr.y] + 1;
                    visited[x][y] = true;
                    queue.add(new Pair(x, y));
                }

                // if destination is reached then break it just after processing result for dest
                if(x == destRow && y == destCol) {
                    break;
                }
            }
        }

        return dis[destRow][destCol];
    }

    public static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 3, 1, 0},
                       {3, 0, 3, 3},
                       {2, 3, 0, 3},
                       {0, 3, 3, 3}};

        int ans = minimumMovesToReachEnd(arr);
        System.out.println(ans);
    }
}
