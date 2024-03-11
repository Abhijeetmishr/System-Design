package DSA.Array.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        int target = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            int l = i + 1;
            int r = nums.length-1;
            while(l < r) {
                if(nums[l] + nums[r] == target - nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);
                    l++;
                } else if(nums[l] + nums[r] > target - nums[i]) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
