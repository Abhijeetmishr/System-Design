package DSA.DP.LIS;
import java.util.*;
/*
 *  Example 1:

    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    Example 2:

    Input: nums = [0,1,0,3,2,3]
    Output: 4
    Example 3:

    Input: nums = [7,7,7,7,7,7,7]
    Output: 1
 */
public class LIS {

    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for(int i = 1; i < n; i++){
            lis[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        int max = lis[0];
        for(int i = 0; i < n; i++){
            max = Math.max(max, lis[i]);
        }
        return max;
    }
    // Time Complexity O(nlogn)
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     int[] tail = new int[n];
    //     tail[0] = nums[0];
    //     int len = 1;
    //     for(int i = 1; i < n; i++){
    //         if(nums[i] > tail[len-1]){
    //             tail[len] = nums[i];
    //             len++;
    //         } else {
    //             int ceil = ceilIdx(tail, 0, len-1, nums[i]);
    //             tail[ceil] = nums[i];
    //         }
    //     }
    //     return len;
    // }

    // public int ceilIdx(int[] tail, int l, int r, int index){
    //     while(l < r){
    //         int m = l + (r-l)/2;
    //         if(tail[m] >= index){
    //             r = m;
    //         } else {
    //             l = m+1;
    //         }
    //     }
    //     return r;
    // }
}
