package src.com.heap;

/**
 * min heap always contains min value at root
 * this property is carried over all it's subtrees as well.
 */

public class MinHeap {
    private int[] arr;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.arr = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    private int getLeft(int i) {
        return 2 * i + 1;
    }

    private int getRight(int i) {
        return 2 * i + 2;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        size++;
        int i = size - 1;
        arr[i] = value;

        while (arr[getParent(i)] > arr[i]) {
            swap(arr, getParent(i), i);
            i = getParent(i);
        }
    }

    public int getMin(){
        if (size < 0) {
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
        }

        return arr[0];
    }

    public int deleteMin() {
        if (size <= 0) {
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
        }
        // returning root as min value and storing last inserted node in root, then heapify it
        int min = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapify(0);
        return min;
    }

    private void heapify(int i) {
        int min = i;
        int left = getLeft(i);
        int right = getRight(i);

        if(left < size && arr[left] < arr[i]){
            min = left;
        }

        else if(right < size && arr[right] < arr[i]){
            min = right;
        }
        if(i != min) {
            swap(arr, min, i);
            heapify(min);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class Test {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(5);
        heap.insert(5);
        heap.insert(4);
        heap.insert(1);
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        heap.insert(10);
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
    }
}
