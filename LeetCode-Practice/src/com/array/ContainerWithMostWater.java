package src.com.array;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int containedWater = 0, n = height.length;

        int i=0, j=n-1;

        while(i<j){
            containedWater = Math.max(containedWater, Math.min(height[i], height[j]) * (j-i));

            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return containedWater;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};

        int maxWaterContained = new ContainerWithMostWater().maxArea(arr);
        System.out.println("Max water contained: " + maxWaterContained);
    }
}
