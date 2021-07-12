package src.com.GS;

public class MedianOfSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0, j=0, k=0;
        int n = nums1.length, m = nums2.length;
        int mid1=0, mid2=0;
        int midValue1=0, midValue2=0;
        if((n+m) % 2 != 0) {
            mid1 = (n+m)/2;
        }else{
            mid1 = (n+m)/2 -1;
        }
        mid2 = (n+m)/2;

        while(i<n && j<m){
            if(nums1[i] < nums2[j]) {
                if(k == mid1) {
                    midValue1 = nums1[i];
                }

                if(k == mid2){
                    midValue2 = nums1[i];
                }
                i++;
                k++;
            }else{
                if(k == mid1) {
                    midValue1 = nums2[j];
                }
                if(k == mid2){
                    midValue2 = nums2[j];
                }
                j++;
                k++;
            }
        }

        while(i<n){
            if(k == mid1) {
                midValue1 = nums1[i];
            }

            if(k == mid2){
                midValue2 = nums1[i];
            }
            i++;
            k++;
        }

        while(j<m){
            if(k == mid1) {
                midValue1 = nums2[j];
            }

            if(k == mid2){
                midValue2 = nums2[j];
            }
            j++;
            k++;
        }

        return (midValue1+midValue2)*0.5;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5};
        int[] arr2 = {2,7};

        double ans = findMedianSortedArrays(arr1, arr2);
        System.out.println(ans);
    }
}
