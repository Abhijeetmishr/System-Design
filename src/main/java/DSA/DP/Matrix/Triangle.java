package DSA.DP.Matrix;
import java.util.*;

/*
 * Given a triangle array, return the minimum path sum from top to bottom.

    For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

    Example 1:
    Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    Output: 11
    Explanation: The triangle looks like:
    2
    3 4
    6 5 7
    4 1 8 3
    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] dp = new int[height+1][height+1];
        
        for(int i = height-1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[i][j] = triangle.get(i).get(j) + 
                            Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
