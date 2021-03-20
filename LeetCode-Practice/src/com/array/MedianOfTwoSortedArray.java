package src.com.array;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArray {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int i=0, n = nums1.length;
            int j=0, m = nums2.length;
            int k=0;
            int firstMidValue=Integer.MIN_VALUE, secondMidValue = Integer.MIN_VALUE;
            int firstMidIndex = (n+m)/2 - 1; // 3
            int secondMidIndex = (n+m)/2; // 4

            if((n+m)%2!=0){
                firstMidIndex = secondMidIndex = (n+m)/2;
            }
            while(i<n && j<m){
                if(nums1[i] <= nums2[j]){
                    if(k == firstMidIndex){
                        firstMidValue = nums1[i];
                    }
                    if(k == secondMidIndex){
                        //System.out.println(nums1[i]);
                        secondMidValue = nums1[i];
                        break;
                    }
                    i++;
                    k++;
                }else if(nums1[i] > nums2[j]){
                    if(k == firstMidIndex){
                        firstMidValue = nums2[j];
                    }
                    if(k == secondMidIndex){
                        secondMidValue = nums2[j];
                        break;
                    }
                    j++;
                    k++;
                }
            }

            while(i<n){
                if(k == firstMidIndex && firstMidValue == Integer.MIN_VALUE){
                    firstMidValue = nums1[i];
                }

                if(k == secondMidIndex && secondMidValue == Integer.MIN_VALUE){
                    secondMidValue = nums1[i];
                    break;
                }
                i++;
                k++;
            }

            while(j<m){
                if(k == firstMidIndex && firstMidValue == Integer.MIN_VALUE){
                    firstMidValue = nums2[j];
                }
                if(k == secondMidIndex && secondMidValue == Integer.MIN_VALUE){
                    secondMidValue = nums2[j];
                    break;
                }
                j++;
                k++;
            }


            //System.out.println(firstMidValue + " " + secondMidValue);
            return (double)((firstMidValue + secondMidValue)*0.5);
        }
    }

}
