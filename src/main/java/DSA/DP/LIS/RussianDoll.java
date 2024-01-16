package DSA.DP.LIS;
import java.util.*;
/*
 *  You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

    One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

    Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

    Note: You cannot rotate an envelope.

    

    Example 1:

    Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
    Output: 3
    Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
    Example 2:

    Input: envelopes = [[1,1],[1,1],[1,1]]
    Output: 1
 */
public class RussianDoll {
    public int maxEnvelopes(int[][] nums) {
        Arrays.sort(nums, new EnvelopeComparator());
        int n = nums.length;
        int[] tail = new int[n];
        int len = 1;
        tail[0] = nums[0][1];
        for(int[] num : nums){
            if(num[1] > tail[len-1]){
                tail[len] = num[1];
                len++;
            } else {
                int c = ceilIdx(tail, 0, len-1, num[1]);
                tail[c] = num[1];
            }
        }
        return len;
    }

    public int ceilIdx(int tail[], int l, int r, int x){
        while(r > l){
            int m = l + (r-l)/2;
            if(tail[m] >= x){
                r = m;
            } else {
                l = m+1;
            }
        }
        return r;
    }

    class EnvelopeComparator implements Comparator<int[]> {
        public int compare(int[] e1, int[] e2){
            return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
        }
    }
}
