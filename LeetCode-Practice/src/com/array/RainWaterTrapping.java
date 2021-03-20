package src.com.array;

// https://leetcode.com/problems/trapping-rain-water/submissions/
public class RainWaterTrapping {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int[] L = new int[n];
        int[] R = new int[n];
        int totalWater = 0;

        L[0] = height[0];
        R[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            L[i] = Math.max(L[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            R[i] = Math.max(R[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            totalWater += Math.min(L[i], R[i]) - height[i];
        }

        return totalWater;
    }
}
