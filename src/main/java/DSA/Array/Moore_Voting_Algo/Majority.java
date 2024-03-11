package DSA.Array.Moore_Voting_Algo;

/*
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
class Majority {
    public int majorityElement(int[] nums) {
        //Based on Moore's Voting algorithm
        int count = 1;
        int candidate = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[candidate] == nums[i]) {
                count++;
                
            } else {
                count--;
            }
            if(count == 0) {
                candidate = i;
                count = 1;
            }
        }

        count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[candidate] == nums[i]) {
                count++;
            }
        }
        if(count <= nums.length/2) return -1;
        return nums[candidate];
    }
}