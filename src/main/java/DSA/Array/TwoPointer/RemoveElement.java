package DSA.Array.TwoPointer;

/**
 * https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        
        int k = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[k++] = nums[i];
            } else {
                continue;
            }
        }
        return k;
    }
}
