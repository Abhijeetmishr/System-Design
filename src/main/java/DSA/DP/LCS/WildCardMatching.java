package DSA.DP.LCS;

public class WildCardMatching {
   /*
    * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

        '?' Matches any single character.
        '*' Matches any sequence of characters (including the empty sequence).
        The matching should cover the entire input string (not partial).

        <-------------------------------------------------------------------------------!>
        Example 1:
        Input: s = "aa", p = "a"
        Output: false
        Explanation: "a" does not match the entire string "aa".

        Example 2:
        Input: s = "aa", p = "*"
        Output: true
        Explanation: '*' matches any sequence.
    */
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        boolean[][] dp = new boolean[n+1][m+1];

        dp[0][0] = true;

        for(int j = 1; j <= m; j++){
            dp[0][j] = false;
        }

        for(int i = 1; i <= n; i++){
            boolean flag = true;
            for(int k = 1; k <= i; k++){
                if(p.charAt(k-1) != '*'){
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?'){
                    dp[i][j] =dp[i-1][j-1];
                }else if(p.charAt(i-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        
        return dp[n][m];
    }
}

/*
 * Recursion
 * public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();

        return match(n-1, m-1, p, s);
    }

    private boolean match(int i, int j, String pattern, String text){
        if(i < 0 && j < 0)  return true;
        if(i < 0 && j >= 0) return false;

        if(i >= 0 && j < 0){
            for(int k = 0; k <= i; k++){
                if(pattern.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }

        if(pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?'){
            return match(i-1, j-1, pattern, text);
        }
        if(pattern.charAt(i) == '*'){
            return match(i, j-1, pattern, text) || match(i-1, j, pattern, text);
        }
        return false;
    }
 */