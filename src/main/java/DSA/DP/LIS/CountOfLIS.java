package DSA.DP.LIS;
import java.util.*;

/*
 *  Given an integer array nums, return the number of longest increasing subsequences.

    Notice that the sequence has to be strictly increasing.
    
    Example 1:
    Input: nums = [1,3,5,4,7]
    Output: 2
    Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
    
    Example 2:
    Input: nums = [2,2,2,2,2]
    Output: 5
    Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 */
public class CountOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] count = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(count, 1);
        int max = 1;
        for(int i = 1; i < n; i++){
            lis[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && 1 + lis[j] > lis[i]){
                    lis[i] = 1 + lis[j];
                    count[i] = count[j];
                } else if(nums[i] > nums[j] && 1 + lis[j] == lis[i]) {
                    count[i] += count[j];
                }
            }
            max = Math.max(max, lis[i]);
        }
        int nos = 0;
        for(int i = 0; i < n; i++){
            if(lis[i] == max){
                nos += count[i];
            }
        }
        return nos;
    }
}
