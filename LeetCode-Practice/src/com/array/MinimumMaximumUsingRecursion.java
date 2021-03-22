package src.com.array;

public class MinimumMaximumUsingRecursion {
    public static int findMinimum(int[] arr, int currentIndex, int n, int min) {
        if (currentIndex == n) {
            return min == Integer.MAX_VALUE ? 0 : min;
        }

        if (arr[currentIndex] < min) {
            min = arr[currentIndex];
        }
        return findMinimum(arr, currentIndex + 1, n, min);
    }

    public static int findMaximum(int[] arr, int currentIndex, int n, int max) {
        if (currentIndex == n) {
            return max == Integer.MAX_VALUE ? 0 : max;
        }

        if (arr[currentIndex] > max) {
            max = arr[currentIndex];
        }
        return findMaximum(arr, currentIndex + 1, n, max);
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 18, 90, 5};
        int n = arr.length;

        int minimum = findMinimum(arr, 0, n, Integer.MAX_VALUE);
        int maximum = findMaximum(arr, 0, n, Integer.MIN_VALUE);
        System.out.println("Minimum element is: " + minimum);
        System.out.println("Maximum element is: " + maximum);
    }
}
