package DSA.DP.LCS;

public class LongestCommonSubsequence {
    public int solve(String A, String B) {
        int m = A.length();
        int n = B.length();
        
        if(m == 0 || n == 0) return 0;
        
        char[] ch1 = A.toCharArray();
        char[] ch2 = B.toCharArray();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 0; i < m+1; i++){
            for(int j = 0; j < n+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(ch1[i-1] == ch2[j-1]){
                    dp[i][j] = 1+dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
