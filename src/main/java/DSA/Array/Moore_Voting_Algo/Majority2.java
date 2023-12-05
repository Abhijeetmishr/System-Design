package DSA.Array.Moore_Voting_Algo;

import java.util.ArrayList;
import java.util.List;
/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
*/
class Majority2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int candidate1 = Integer.MAX_VALUE, candidate2 = Integer.MAX_VALUE;
        int count1 = 0, count2 = 0;

        for(int i = 0; i < nums.length; i++){
            // case 1: I want to vote for Biden or Trump
            if(nums[i] == candidate1)
                count1++;

            // case 2: I want to run for the president
            else if(nums[i] == candidate2)
                count2++;
            
            else if(count1 == 0){
                candidate1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0){
                candidate2 = nums[i];
                count2 = 1;
            } 
            // case 3: fuck sleepy Joe and crazy Trump, let James be the president
            else {
                count1--;
                count2--;
            }
        }
        // After election, we need to count the vote again.
        count1 = 0; 
        count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate1)
                count1++;
            else if(nums[i] == candidate2)
                count2++;
        }
        if(count1 > nums.length/3)
            res.add(candidate1);
        if(count2 > nums.length/3)
            res.add(candidate2);

        return res;
    }
}

/**
There can be at most k - 1 major element in an array if the major element appears more than ⌊n / k⌋ times.

In the begining, we assume there are k - 1 candidates:

These candidates can take any value;
The vote of these candidates must be 0
Then we traverse the array:

If current element equals to the value of any candidate, the candidate get a vote; (one voter can only vote for one candidate)
If the vote of any candidate is 0, then current element is set as a new candidate and he can get a vote immediately; (A voter can also be elected)
Otherwise, current element vote against all candidates and all candidates lose a vote.
Assume you're voting for the president. If you want to select Trump or Biden. Ok, just vote for them (case 1). If Trump is impeached or Biden is dead, now you can run for the president (case 2). If you want to vote for Lebron James, of course both Biden or Trump won't get your vote (case 3).

After election, we need to count the vote of each candidate to see whether they are qualified for the position, i.e., the vote is larger than ⌊n / k⌋.
*/
