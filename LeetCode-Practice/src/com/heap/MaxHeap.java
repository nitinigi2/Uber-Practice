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

    public int[] mergeHeaps(int[] arr, int[] brr) {
        int n = arr.length;
        int m = brr.length;
        int k = n + m;
        int[] ans = new int[k];

        for(int i=0;i<n;i++){
            ans[i] = arr[i];
        }

        for(int i=0;i<m;i++){
            ans[i+n] = brr[i];
        }

        for(int i=k/2;i>=0;i--){
            heapify(ans, k, i);
        }

        return ans;
    }

    private void heapify(int[] arr, int k, int i) {
        int max = i;
        int left = getLeft(i);
        int right = getRight(i);

        if(left < k && arr[left] > arr[max]){
            max = left;
        }

        if(right < k && arr[right] > arr[max]){
            max = right;
        }

        if(i != max){
            swap(arr, i, max);
            heapify(arr, k, max);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

class Test1{
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        /*int arr[] = { 90, 15, 10, 7, 12, 2, 7, 3 };
        int n = arr.length - 1;
        if (maxHeap.isMaxHeap(arr, n)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }*/
        int[] a = {10, 5, 6, 2};
        int[] b = {12, 7, 9};
        int[] ans = maxHeap.mergeHeaps(a, b);
        for(int x : ans){
            System.out.println(x);
        }
    }
}
