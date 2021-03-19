package src.com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1;
                int r = n - 1;
                int x = nums[i];
                while (l < r) {
                    if (x + nums[l] + nums[r] == 0) {
                        ans.add(Arrays.asList(x, nums[l], nums[r])); // creating pair and adding it to ans
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (r > l && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (x + nums[l] + nums[r] < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

        System.out.println(new ThreeSum().threeSum(arr));
    }

}
