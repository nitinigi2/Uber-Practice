package src.com.array;

import java.util.PriorityQueue;

// Program to find the nth minimum (or maximum) element of an array.
public class NthMinimumMaximumElement {

    public static void findNthSmallestElement(int[] arr, int k){
        // create a min heap and then remove element element one by one
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int x : arr){
            queue.add(x);
        }
        while (k>1){
            queue.poll();
            k--;
        }
        System.out.println("kth smallest element: " + queue.peek());
    }

    public static void findNthLargestElement(int[] arr, int k){
        // create a max heap and then remove element element one by one
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->b-a);
        for(int x : arr){
            queue.add(x);
        }
        while (k>1){
            queue.poll();
            k--;
        }
        System.out.println("kth largest element: " + queue.peek());
    }

    public static void main(String[] args) {
        int arr[] = { 12, 3, 5, 7, 19 };
        int k = 2;
        findNthSmallestElement(arr, k);
        findNthLargestElement(arr, k);
    }

}
