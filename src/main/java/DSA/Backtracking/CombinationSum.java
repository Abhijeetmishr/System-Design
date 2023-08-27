package DSA.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(ans, new ArrayList<>(), nums, target, 0);
        return ans;
    }
    private void backtracking(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) {
            ans.add(new ArrayList<>(tempList));
            return;
        } else {
            for(int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtracking(ans, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
