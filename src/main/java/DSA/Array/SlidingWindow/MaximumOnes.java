package DSA.Array.SlidingWindow;

/*
 * Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to get longest continuous sequence of 1s.
 * Expected time complexity is O(n) and auxiliary space is O(1). 
*/
public class MaximumOnes {
     // Find the index of 0 to replace with 1 to get the maximum sequence
    // of continuous 1's
    public static int findIndexofZero(int[] A)
    {
        int max_count = 0;          // stores maximum number of 1's (including 0)
        int max_index = -1;         // stores index of 0 to be replaced
 
        int prev_zero_index = -1;   // stores index of previous zero
        int count = 0;              // stores current count of zeros
 
        // consider each index `i` in the array
        for (int i = 0; i < A.length; i++)
        {
            // if the current element is 1
            if (A[i] == 1) {
                count++;
            }
            // if the current element is 0
            else {
                // reset count to 1 + number of ones to the left of current 0
                count = i - prev_zero_index;
 
                // update `prev_zero_index` to the current index
                prev_zero_index = i;
            }
 
            // update maximum count and index of 0 to be replaced if required
            if (count > max_count)
            {
                max_count = count;
                max_index = prev_zero_index;
            }
        }
 
        // return index of 0 to be replaced or -1 if the array contains all 1's
        return max_index;
    }
 
    public static void main (String[] args)
    {
        int[] A = { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };
 
        int index = findIndexofZero(A);
 
        if (index != -1) {
            System.out.print("Index to be replaced is " + index);
        }
        else {
            System.out.print("Invalid input");
        }
    }

    /* Approach
     * We can efficiently solve this problem in linear time and constant space.
     * The idea is to traverse the given array and maintain an index of the previous zero encountered.
     * We can then easily find out the total number of 1’s between the current zero and the last zero for each subsequent zeros.
     * For each element, check if the maximum sequence of continuous 1’s ending at that element (including the last zero, which is now replaced by 1) exceeds the maximum sequence found so far.
     * If yes, update the maximum sequence to the current sequence length and index of optimal zero and index the last zero encountered.
     */
}
