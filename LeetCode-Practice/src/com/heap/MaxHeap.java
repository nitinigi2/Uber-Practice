package src.com.heap;

public class MaxHeap {

    private int getLeft(int i) {
        return 2 * i + 1;
    }

    private int getRight(int i) {
        return 2 * i + 2;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    public boolean isMaxHeap(int[] arr, int n){
        for(int i=0;i<n;i++){
            int rootIndex = i;
            int left = getLeft(i);
            int right = getRight(i);

            if(left < n && right<n && (arr[rootIndex] < arr[left] || arr[rootIndex] < arr[right])){
                return false;
            }
        }
        return true;
    }
}

class Test1{
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        int arr[] = { 90, 15, 10, 7, 12, 2, 7, 3 };
        int n = arr.length - 1;
        if (maxHeap.isMaxHeap(arr, n)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }
}
