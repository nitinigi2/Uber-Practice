package src.com.GS;

public class SecondSmallest {

    public static int secondSmallest(int[] arr) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        if (arr.length < 2) {
            return 0;
        }
        for (int x : arr) {
            if (x < min) {
                secondMin = min;
                min = x;
            } else if (x < secondMin) {
                secondMin = x;
            }
        }

        return secondMin;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, -2, 2};
        int ans = secondSmallest(arr);
        System.out.println(ans);
    }
}
