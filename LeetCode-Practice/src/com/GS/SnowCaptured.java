package src.com.GS;

/*
Given an array of non-negative integers representing the elevations
        from the vertical cross section of a range of hills, determine how
        many units of snow could be captured between the hills.

        See the example array and elevation map below.
        ___
        ___                |   |        ___
        |   |        ___    |   |___    |   |
        *        ___|   |    ___|   |   |   |   |   |   |
        ___|___|___|___|___|___|___|___|___|___|___|___
        { 0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0 }

        ___
        ___                |   |        ___
        |   | *   *  _*_  * |   |_*_  * |   |

        *        ___|   | *  _*_|   | * |   |   | * |   |
        ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
        { 0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0 }

        Solution: In this example 13 units of snow (*) could be captured.

        Signature: public static Integer computeSnowpack(Integer[] arr) {
        }
        Test Cases:
        Input : {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}
        Output: 13

        Input : {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        Output:10
*/

public class SnowCaptured {
    public static int computeSnowpack(int[] arr) {
        int total = 0;
        int n = arr.length;
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = arr[0];
        R[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            L[i] = Math.max(L[i - 1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            R[i] = Math.max(R[i + 1], arr[i]);
        }

        for (int i = 0; i < n; i++) {
            total += Math.min(L[i], R[i]) - arr[i];
        }

        return total;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0};
        System.out.println(computeSnowpack(arr));
    }
}
