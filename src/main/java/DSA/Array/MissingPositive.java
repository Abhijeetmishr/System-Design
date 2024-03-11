package DSA.Array;

import java.util.HashSet;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/first-missing-positive/description/
 */
public class MissingPositive {
     public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        for(int i = 1; i <= n; i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return n+1;
    }
    // Time Complexity - O(n) && Space Complexity - O(1)
    //     for (int i = 0; i < nums.length; i++){
    //         if( nums[i] > 0 && nums[i]<=n ){
    //             int pos = nums[i]-1;
    //             if(nums[pos] != nums[i]){
    //                 int temp = nums[pos];
    //                 nums[pos] = nums[i];
    //                 nums[i] = temp;
    //                 i--;
    //             }
    //         }
    //     }
    //     for (int i = 0; i < n; i++)
    //         if (nums[i] != i + 1)
    //             return i + 1;
    //     return n + 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; ++i) {
            nums[i] = in.nextInt();
        }
        int result = firstMissingPositive(nums);
        System.out.println(result);
    }
}
