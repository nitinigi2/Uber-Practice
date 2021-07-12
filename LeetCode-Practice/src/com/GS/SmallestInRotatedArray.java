package src.com.GS;

public class SmallestInRotatedArray {

    public static int FindMin(int arr[]) {
        int pivot = findPivot(arr, 0, arr.length);
        if (pivot == -1) {
            return arr[pivot+1];
        }
        return arr[pivot];
    }

    private static int findPivot(int[] arr, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid < end - 1 && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                return mid;
            }
            // determine whether to go left or right
            if (arr[0] > arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int ans = FindMin(arr);
        System.out.println(ans);
    }
}

//1,2,3,4,5
//2,3,4,5,1
//3,4,5,1,2
//4,5,1,2,3
