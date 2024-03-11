package DSA.DP.Unbounded_Knapsack;

import java.util.Scanner;

/**
 *  Example 1:

    Input: amount = 5, coins = [1,2,5]
    Output: 4
    Explanation: there are four ways to make up the amount:
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1
    Example 2:

    Input: amount = 3, coins = [2]
    Output: 0
    Explanation: the amount of 3 cannot be made up just with coins of 2.
    Example 3:

    Input: amount = 10, coins = [10]
    Output: 1
 */
public class CoinChangeI {
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int N = sc.nextInt();
		int []coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}
		long ans = coinChange(A, N, coins);
		System.out.println(ans);
		sc.close();
	}

	public static long coinChange(int amount, int n, int []coins) {
		long[][] dp = new long[n + 1][amount+1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= amount; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = (long)(dp[i][j-coins[i-1]] + dp[i-1][j]);
                }else{
                    dp[i][j] = (long)dp[i-1][j];
                }
            }
        }
        return dp[n][amount];

		// long[] dp = new long[amount + 1];
        // dp[0] = 1;
        // for (int coin : coins) {
        //     for (int i = coin; i <= amount; i++) {
        //         dp[i] += (long)dp[i-coin];
        //     }
        // }
        // return dp[amount];
	}
}
