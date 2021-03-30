package src.com.array;

public class Sorting {
    public static void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        System.out.println("Bubble sort: ");
        printArray(arr, n);
    }

    public static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int j = i;
            int temp = arr[i];
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        System.out.println("Insertion sort: ");
        printArray(arr, n);
    }

    public static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
        System.out.println("Selection sort: ");
        printArray(arr, n);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int n = mid - l + 1;
        int m = r - mid;
        int[] L = new int[n];
        int[] R = new int[m];

        int i = 0, j = 0, k = l;

        for (int t = 0; t < n; t++) {
            L[t] = arr[l + t];
        }

        for (int t = 0; t < m; t++) {
            R[t] = arr[mid + t + 1];
        }

        while (i < n && j < m) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < m) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = findPivot(arr, l, r);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, r);
        }
    }

    private static int findPivot(int[] arr, int l, int r) {
        int pivot = arr[r];
        int j = 0;
        for (int i = l; i < r; i++) {
            if (arr[i] < pivot) {
                swap(arr, j, i);
                j++;
            }
        }
        swap(arr, r, j);
        return j;
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, -1, 10, 4, 66, 3};
        int n = arr.length;
        bubbleSort(arr, n);
        insertionSort(arr, n);
        selectionSort(arr, n);
        System.out.println("Merge sort: ");
        mergeSort(arr, 0, n - 1);
        printArray(arr, n);
        System.out.println("Quick sort: ");
        quickSort(arr, 0, n - 1);
        printArray(arr, n);
    }
}

// -1, 2
