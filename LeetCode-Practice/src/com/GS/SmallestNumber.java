package src.com.GS;

public class SmallestNumber {

    public static int smallest(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++) {
            if(min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 2, 9, 5};
        System.out.println(smallest(arr));
    }
}
