package DSA.Heap;

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class Kth_Largest_Element {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int L = 0, R = n - 1;
        int pivot_idx = 0;

        // Kth Largest Pivot element - nums[k-1] (descending order partition)
        while (true) {
            pivot_idx = partition_algo(nums, L, R);

            if (pivot_idx == k - 1) {
                break;
            } else if (pivot_idx > k - 1) {
                R = pivot_idx - 1;
            } else {
                L = pivot_idx + 1;
            }
        }
        return nums[pivot_idx];
    }

    public int partition_algo(int[] nums, int L, int R) {
        int P = nums[L];
        int i = L + 1;
        int j = R;

        while (i <= j) {
            while (i <= j && nums[i] > P) {
                i++;
            }
            while (i <= j && nums[j] < P) {
                j--;
            }
            if (i <= j) {
                // swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        // swap pivot element to its correct position
        int temp = nums[L];
        nums[L] = nums[j];
        nums[j] = temp;

        return j; // P is at jth index
    }
}
