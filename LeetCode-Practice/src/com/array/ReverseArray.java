package src.com.array;

import java.util.stream.Stream;

public class ReverseArray {

    public static void reverse(int[] arr) {
        int i=0, j=arr.length-1;
        while(i<j){
            swap(arr, i, j);
            i++;
            j--;
        }
        for(int x : arr){
            System.out.print(x + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 10, 3};
        reverse(arr);
    }

}
