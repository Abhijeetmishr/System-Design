package DSA.Array.JumpGame;

/**
 * https://leetcode.com/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150
 */

 /**
  * In this problem, we can jump from ith position up to the position a[i]+i. We skip the indices between them.

    So we have a[i] options from each position. And we explore all of the options in each step to see if we reach the end of the array.

    The recurrence relation is

    L(i) = L(i+1) || L(i+2) ||.........|| L(i+a[i])

    Here L(i) returns true if we can reach the end of the array from the ith index.

    The base case for this recursion is that we reach L(x) where x>=n we return true.

    However, if we land at a position with a[i]==0 we return false.
  */
public class JumpGame1 {
    public boolean canJump(int[] nums) {
        int jump = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(jump < i)
                return false;
            jump = Math.max(jump, i + nums[i]);
        }
        return true;
    }
}
