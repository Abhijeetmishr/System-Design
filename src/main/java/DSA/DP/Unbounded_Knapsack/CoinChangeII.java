package DSA.DP.Unbounded_Knapsack;

/**
 * https://leetcode.com/problems/coin-change/
 * 
 *  Example 1:

    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
    Example 2:

    Input: coins = [2], amount = 3
    Output: -1
    Example 3:

    Input: coins = [1], amount = 0
    Output: 0
 */
public class CoinChangeII {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int v = amount;
        int[][] dp = new int[n+1][v+1];
        dp[0][0] = 0;
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < v+1; j++){
                if(i == 0 && j > 0){
                    dp[i][j] = Integer.MAX_VALUE-1;
                }
                if(i > 0 && j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < v+1; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]]+1, dp[i-1][j]);
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
         
	    return dp[n][v] == Integer.MAX_VALUE-1 ? -1 : dp[n][v];
	    
    }
}
