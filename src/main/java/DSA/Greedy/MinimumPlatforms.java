package DSA.Greedy;

import java.util.Arrays;

public class MinimumPlatforms {
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
       
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 1;
        int j = 0;
        int count = 1;
        int max = 1;
        
         while(i < n) {
             if(arr[i] <= dep[j]) {
                count = count+1;
                i++; 
             } else {
                count = count-1;
                j++;
             }
             max = Math.max(count, max);
         }
         return max;
        
    }
}
