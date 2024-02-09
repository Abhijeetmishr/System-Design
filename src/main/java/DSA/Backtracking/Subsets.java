package DSA.Backtracking;

import java.util.ArrayList;
import java.util.List;

//Generate all the subsets for {1, 2, 3}
//Output - {},{1},{2},{3},{1,2},{2,3},{1,3},{1,2,3}

public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    generateSubsets(0, subsets, new ArrayList<>(), nums);
    return subsets;
  }

  public void generateSubsets(int index, List<List<Integer>> subsets, List<Integer> current, int nums[]){
    subsets.add(new ArrayList<>(current));
    for(int i = index; i < nums.length; i++){
      current.add(nums[i]);
      generateSubsets(i+1, subsets, current, nums);
      current.remove(current.size()-1);
    }
  }
}
