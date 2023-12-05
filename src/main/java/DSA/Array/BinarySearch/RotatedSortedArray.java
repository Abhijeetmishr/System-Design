package DSA.Array.BinarySearch;
/*
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */
public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;

        while(low <= high){
            int mid = (high + low)/2;
            if(nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } if(nums[mid] <= nums[high]) {
                if(target > nums[mid] && target <= nums[high]){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } 
        }
        return -1;
    }
}
