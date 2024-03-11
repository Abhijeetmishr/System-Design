package DSA.DP.LCS;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break/solutions/169383/solved-the-time-complexity-of-the-brute-force-method-should-be-o-2-n-and-prove-it-below/?envType=study-plan-v2&envId=dynamic-programming
 */
public class WordBreak {

    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        // initialize variables
        int i, j, k;

        // create a TreeSet to store the words in dictionary
        TreeSet<String> mp = new TreeSet<String>();

        // add all words from dictionary to the TreeSet
        for (i = 0; i < n; i++)
            mp.add(dictionary.get(i));

        int len = s.length();

        // create a dynamic programming array to store if a substring can be broken into
        // words
        ArrayList<Boolean> dp = new ArrayList<Boolean>(len + 1);

        // initialize dp array with false values
        for (i = 0; i < len; i++)
            dp.add(i, false);

        // initialize the first index of the dp array as true
        dp.add(0, true);

        // iterate through each index of the string
        for (i = 1; i <= len; i++) {
            for (j = 0; j < len; j++) {
                // check if substring from index j to i is present in dictionary
                if (dp.get(j) && mp.contains(s.substring(j, i))) {
                    // if yes, set the dp value at index i as true and break the loop
                    dp.add(i, true);
                    break;
                }
            }
        }

        // check if the last index of dp array is true, if yes return 1
        if (dp.get(len))
            return 1;

        // if not, return 0
        return 0;
    }

    
    // public boolean wordBreak(String s, List<String> wordDict) {
    // // put all words in hashset
    // Set<String> set = new HashSet<>(wordDict);
    // return wb(s, set);
    // }

    // public boolean wb(String s, Set<String> set) {
    // int len = s.length();
    // if (len == 0)
    // return true;

    // for (int i = 1; i <= len; ++i) {
    // if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
    // return true;
    // }
    // }
    // return false;
    // }
}
