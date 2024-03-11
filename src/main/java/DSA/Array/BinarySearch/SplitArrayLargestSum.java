package DSA.Array.BinarySearch;

/*
 * https://leetcode.com/problems/split-array-largest-sum/
 * SAME AS ALLOCATE MIN PAGES
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int N = nums.length;
        int low = 0, high = 0;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFeasible(nums, k, mid)) {
                res = Math.min(mid, res);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public boolean isFeasible(int[] nums, int m, int mid) {
        int sum = 0;
        int requiredSubarrays = 1;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum > mid) {
                requiredSubarrays++;
                sum = nums[i];
            }
        }

        if (requiredSubarrays <= m) {
            return true;
        }

        return false;
    }
}
