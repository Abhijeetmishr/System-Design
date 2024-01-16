package DSA.DP.LCS;
import java.util.*;

/**
 * https://leetcode.com/problems/word-break/solutions/169383/solved-the-time-complexity-of-the-brute-force-method-should-be-o-2-n-and-prove-it-below/?envType=study-plan-v2&envId=dynamic-programming
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j <= i; j++){
                String w2Check = s.substring(j, i+1);
                if(wordDict.contains(w2Check)){
                    if(j > 0){
                        dp[i] += dp[j-1];
                    } else {
                        dp[i] += 1;
                    }
                }
            }
        }
        return dp[s.length() - 1] > 0;
    }
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     // put all words in hashset
    //     Set<String> set = new HashSet<>(wordDict);
    //     return wb(s, set);
    // }

    // public boolean wb(String s, Set<String> set) {
    //     int len = s.length();
    //     if (len == 0)
    //         return true;

    //     for (int i = 1; i <= len; ++i) {
    //         if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
