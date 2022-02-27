package src.com.graph;

import java.util.Random;

public class MatrixGenerator {
    static Random random = new Random();

    static int[][] generateMatrix() {
        int n = random.nextInt(10);
        int m = random.nextInt(10);

        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                arr[i][j] = random.nextInt(3);
            }
        }

        return arr;
    }

    public static int[] arrayGenerator() {
        int n = random.nextInt(30);

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = random.nextInt(10);
        }
        return arr;
    }

    public static String[] stringArrayGenerator(){
        int n = random.nextInt(5);
        int m = random.nextInt(10);
//
//        int n = 1000;
//        int m = 1000;

        String[] ans = new String[n];
        for(int i=0;i<n;i++){
            ans[i] = generateRandomString(m);
        }
        return ans;
    }

    public static String generateRandomString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] value = {'.', 'L', 'E'};
        for(int i=0;i<n;i++) {
            stringBuilder.append(value[random.nextInt(3)]);
        }

        return stringBuilder.toString();
    }
}
