package src.com.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InfectedPersonCount {
    // Left, right, Up, Down directions
    private static int[] R = {0, 0, 1, -1};
    private static int[] C = {-1, 1, 0, 0};

    public static void main(String[] args) {
        int[][] arr = MatrixGenerator.generateMatrix();

        int n = arr.length;
        int m = arr[0].length;

        System.out.println(n + " " + m);

        ShortPath.printMatrix(arr);
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int m = scan.nextInt();
//
//        int[][] matrix = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                matrix[i][j] = scan.nextInt();
//            }
//        }

        System.out.println("Output:");
        System.out.println(totalNoOfInfected(arr, n, m));
    }

    public static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    public static int totalNoOfInfected(int[][] arr, int n, int m) {
        int count = 0;

        Queue<Pair> pairQueue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    pairQueue.add(new Pair(i, j));
                    visited[i][j] = true;
                    count++;
                }
            }
        }

        while (!pairQueue.isEmpty()) {
            Pair pair = pairQueue.poll();
            for (int i = 0; i < 4; i++) {
                int x = pair.x + R[i];
                int y = pair.y + C[i];
                if (isValid(x, y, n, m) && !visited[x][y] && arr[x][y] == 1) {
                    pairQueue.add(new Pair(x, y));
                    visited[x][y] = true;
                    count++;
                }
            }
        }
        return count;
    }
}


