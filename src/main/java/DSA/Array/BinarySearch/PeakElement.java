package DSA.Array.BinarySearch;
/**
    * A peak element is an element that is strictly greater than its neighbors.
    * Given a 0-indexed integer array nums, find a peak element, and return its index.
    * If the array contains multiple peaks, return the index to any of the peaks.
    * Input: nums = [1,2,3,1]
    * Output: 2
    * Explanation: 3 is a peak element and your function should return the index number 2.
 */
public class PeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;

        while(low <= high){
            int mid = (low + high)/2;

            if((mid == 0 || nums[mid-1] <= nums[mid]) && 
                (mid == n-1 || nums[mid+1] <= nums[mid])){
                    return mid;
            } else if(mid > 0 && nums[mid-1] >= nums[mid]){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
