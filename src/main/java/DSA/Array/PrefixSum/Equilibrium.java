package DSA.Array.PrefixSum;

/**
 * https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1?page=1&status=solved&sortBy=submissions
 */
public class Equilibrium {
    public static int equilibriumPoint(long arr[], int n) {
        if (n == 1) {
            return 1;
        }
        long sum = 0;
        long preSum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        for (int i = 1; i < n; i++) {
            preSum += arr[i-1];
            long suffixSum = sum - arr[i] - preSum;
            if (suffixSum == preSum) {
                return i+1;
            }
        }
        return -1;
    }
}
