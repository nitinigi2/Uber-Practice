package src.com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Laser {
    public static int isLaserKillPossible(String[] arr, int m, int n) {
        char[][] matrix = new char[n][m];
        String str = "";
        for (int i = 0; i < n; i++) {
            str = arr[i];
            for (int j = 0; j < m; j++) {
                matrix[i][j] = str.charAt(j);
            }
        }

        return bfs(matrix, n, m);
    }

    private static int bfs(char[][] matrix, int n, int m) {
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 'L') {
                    queue.add(new Pair(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            killAllUp(pair.x, pair.y, matrix);
            killAllDown(pair.x, pair.y, matrix);
            killAllRight(pair.x, pair.y, m, matrix);
        }

        return checkAnyEnemyLeft(matrix, n, m);
    }

    private static int checkAnyEnemyLeft(char[][] matrix, int n, int m) {
        int totalEnemiesCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 'E') {
                    totalEnemiesCount++;
                }
            }
        }
        return totalEnemiesCount;
    }

    public static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    public static void killAllUp(int i, int j, char[][] matrix) {
        while (i-- > 0) {
            matrix[i][j] = '_';
        }
    }

    public static void killAllDown(int i, int j, char[][] matrix) {
        while (j-- > 0) {
            matrix[i][j] = '_';
        }
    }

    public static void killAllRight(int i, int j, int m, char[][] matrix) {
        while (j++ < m - 1) {
            matrix[i][j] = '.';
        }
    }

    public static void main(String[] args) {
        String[] arr = {"L.E.E", "E.E.L"};

//        String[] arr = MatrixGenerator.stringArrayGenerator();
//        System.out.println("Test case: ");
//        System.out.println(arr[0].length() + " " + arr.length);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        int l = arr[0].length();
        int n = arr.length;

        System.out.println("Output:");
        System.out.println(isLaserKillPossible(arr, l, n));
    }
}




