package DSA.Array.TwoPointer;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[k]) {
                continue;
            } else {
                k++;
                nums[k] = nums[i];
            }
        }
        return k+1;
    }
}
