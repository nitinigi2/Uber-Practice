package src.com.array;

import java.util.HashMap;
// link : https://leetcode.com/problems/two-sum/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int firstIndex = -1, secondIndex = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int current = nums[i];
            if(map.containsKey(target - current)){
                return new int[]{map.get(target - current), i};
            }else{
                map.put(current, i);
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 4, 1, 7, 9, 10};
        int target = 3;

        int[] indexes = new TwoSum().twoSum(arr, target);
        System.out.println("First Index : " + indexes[0] + " Second Index: " + indexes[1]);
    }
}
