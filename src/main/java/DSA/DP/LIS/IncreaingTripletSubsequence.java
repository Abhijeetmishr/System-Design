package DSA.DP.LIS;

/*
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

 

    Example 1:

    Input: nums = [1,2,3,4,5]
    Output: true
    Explanation: Any triplet where i < j < k is valid.
    Example 2:

    Input: nums = [5,4,3,2,1]
    Output: false
    Explanation: No triplet exists.
 */
public class IncreaingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n];
        tail[0] = nums[0];
        int len = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > tail[len-1]){
                tail[len] = nums[i];
                len++;
            } else {
                int ceil = ceilIdx(tail, 0, len-1, nums[i]);
                tail[ceil] = nums[i];
            }
        }
        return len >= 3 ? true : false;
    }

    public int ceilIdx(int[] tail, int l, int r, int index){
        while(l < r){
            int m = l + (r-l)/2;
            if(tail[m] >= index){
                r = m;
            } else {
                l = m+1;
            }
        }
        return r;
    }
}
