package src.com.array;

// https://leetcode.com/problems/product-of-array-except-self/

public class ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n]; // store left side product
        int[] R = new int[n]; // store right side product
        int[] ans = new int[n];

        L[0] = 1;
        for(int i=1;i<n;i++){
            L[i] = nums[i-1] * L[i-1];
        }

        R[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            R[i] = nums[i+1] * R[i+1];
        }

        for(int i=0;i<n;i++){
            ans[i] = R[i] * L[i];
        }
        return ans;
    }
}
