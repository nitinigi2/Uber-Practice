package src.com.array;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstLastElementPosition {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return new int[] {-1, -1};
        int start = findStartingIndex(nums, n, target);
        int end = findEndingIndex(nums, n, target);

        return new int[] {start, end};
    }

    public int findStartingIndex(int[] arr, int n, int target){
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(mid>0 && arr[mid] == target && arr[mid-1] == target){
                high = mid-1;
            }
            else if(arr[mid] < target){
                low = mid+1;
            }else if(arr[mid] == target){
                return mid;
            }else{
                high = mid-1;
            }
        }

        return -1;
    }

    public int findEndingIndex(int[] arr, int n, int target){
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(mid<n-1 && arr[mid] == target && arr[mid+1] == target){
                low=mid+1;
            }
            else if(arr[mid] > target){
                high = mid-1;
            }else if(arr[mid] == target){
                return mid;
            }else{
                low = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5,7,7,8,8,10};
        int target = 8;
        int[] range = new FirstLastElementPosition().searchRange(arr, target);
        System.out.println("Start index: " + range[0] + " Ending index: " + range[1]);
    }
}
