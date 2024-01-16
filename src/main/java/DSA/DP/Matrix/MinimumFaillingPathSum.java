package DSA.DP.Matrix;

/*
 * https://leetcode.com/problems/minimum-falling-path-sum/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class MinimumFaillingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int j = 0; j < m; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(j == 0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if(j == m-1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                } else {
                     dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i-1][j+1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++){
            if(min > dp[n-1][j]) min = dp[n-1][j]; 
        }
        return min;
    }
}
