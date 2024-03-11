package DSA.Array.BinarySearch;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 */
public class KthSmallestPair {
     private int[] nums;

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        this.nums = nums;
        int min = 0;
        int max = nums[nums.length - 1] - nums[0];

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (noOfPairsWithDistanceLessThanOrEqualTo(mid) < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    private int noOfPairsWithDistanceLessThanOrEqualTo(int distance) {
        int total = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] - nums[left] <= distance) {
                total += right - left;
                right++;
            } else {
                left++;
            }
        }

        return total;
    }
}
