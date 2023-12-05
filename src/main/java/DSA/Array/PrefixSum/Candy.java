package DSA.Array.PrefixSum;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies = 0;
        int left[] = new int[ratings.length];
        Arrays.fill(left, 1);
        int right[] = new int[ratings.length];
        Arrays.fill(right, 1);
        for(int i = 0; i < ratings.length-1; i++) {
            if(ratings[i] < ratings[i+1]) {
                left[i+1] = left[i+1] + left[i];
            }
        }
        for(int i = n-1; i > 0 ; i--) {
            if(ratings[i] < ratings[i-1]) {
                right[i-1] = right[i-1] + right[i];
            }
        }
        for(int i = 0; i < left.length; i++) {
            candies += Math.max(left[i], right[i]);
        }
        return candies;
    }
}
