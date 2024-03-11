package DSA.Array.TwoPointer;

import java.util.LinkedHashMap;

public class TwoSum {

    // if array not sorted use this 
     public int[] twoSumUnsortedArray(int[] nums, int target) {
        
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // else if array sorted use this
    public int[] twoSumSortedArray(int[] nums, int target) {
        
        int l = 0, r = nums.length-1;

        while(l < r){
            if(nums[l] + nums[r] == target){
                return new int[]{l ,r};
            } else if(nums[l] + nums[r] > target){
                r--;
            } else {
                l++;
            }
        }
        return null;
    }
}
