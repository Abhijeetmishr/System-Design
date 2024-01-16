package DSA.Array.BinarySearch;

public class MedianOfTwoSortedArrays {
    /*
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

        The overall run time complexity should be O(log (m+n)).
        nums1 = {10,20,30,40,50}
        nums2 = {5,15,25,35,45,55,65,75,85}
     */
    private double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2){
            findMedianSortedArrays(nums2, nums1);
        }
        int l = 0;
        int r = n1;

        while(l <= r){
            int mid1 = (l + r)/2;
            int mid2 = (n1+n2+1)/2 - mid1;

            int maxleft1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1-1];
            int minRight1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];

            int maxleft2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2-1];
            int minRight2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];

            if(maxleft1 <= minRight2 && maxleft2 <= minRight1){
                if((n1+n2)%2 == 0){
                    return (double)(Math.max(maxleft1, maxleft2) + Math.min(minRight1, minRight2))/2;
                } else {
                    return (double)Math.max(maxleft1, maxleft2);
                }
            } else if(minRight1 < maxleft2){
                l = mid1+1;
            }else {
                r = mid1-1;
            }
        }
        return -1;
    }
}
