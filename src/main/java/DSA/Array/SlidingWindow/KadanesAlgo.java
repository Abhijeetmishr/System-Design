package DSA.Array.SlidingWindow;

/*
 * https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1?page=1&status=solved&sortBy=submissions
 */
public class KadanesAlgo {
    long maxSubarraySum(int arr[], int n){
        long maxsum = arr[0];
        long currsum = arr[0];

        for(int i = 1; i < n; i++){
            currsum = Math.max(arr[i], currsum+arr[i]);
            maxsum = Math.max(maxsum, currsum);
        }
        return maxsum;
    }
}
