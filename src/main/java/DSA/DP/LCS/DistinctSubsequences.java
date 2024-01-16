package DSA.DP.LCS;

/*
 * https://leetcode.com/problems/distinct-subsequences/?envType=study-plan-v2&envId=dynamic-programming
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        if(m == 0 || n == 0) return 0;
        
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++){
            dp[i][0] = 1;
        }
    
        
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(ch1[i-1] == ch2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}
