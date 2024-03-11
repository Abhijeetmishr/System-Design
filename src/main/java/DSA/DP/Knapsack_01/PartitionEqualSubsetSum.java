package DSA.DP.Knapsack_01;
/*
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 */
public class PartitionEqualSubsetSum {
    static int equalSumPartition(int n,int[] arr){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        if(sum % 2 != 0) return 0;
        return subsetSum(arr, sum/2) == true ? 1 : 0;
    }

    static boolean subsetSum(int a[], int sum){
        int n = a.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if(i == 0 && j > 0){
                    dp[i][j] = false;
                }else if(j == 0){
                    dp[i][j] = true;
                } else if(a[i-1] <= j){
                    dp[i][j] = dp[i-1][j - a[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
