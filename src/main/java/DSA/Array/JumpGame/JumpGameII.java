package DSA.Array.JumpGame;

import java.util.Arrays;
import java.util.Scanner;

public class JumpGameII {
    static int jump(int[] nums) {
        /**
         int totalJumps = 0;

        //destination is last index
        int destination = nums.length-1;
        int coverage = 0, lastJumpIdx = 0;

        //Base case
        if(nums.length == 1) return 0;

        //Greedy strategy: extend coverage as long as possible

        for(int i = 0; i < nums.length; i++){
            coverage = Math.max(nums[i] + i, coverage);
            if(i == lastJumpIdx){
                lastJumpIdx = coverage;
                totalJumps++;

                //check if we reached destination already
                if(coverage >= destination){
                    return totalJumps;
                }
            }
        }
        return totalJumps;
        */

        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j <= i; j++){
                if(i <= j + nums[j]){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length-1]; 
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter array length: ");
        int n =  sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Minimum no of Jumps: " + jump(arr));
    }
}
