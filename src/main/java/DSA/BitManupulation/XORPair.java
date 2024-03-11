package DSA.BitManupulation;

import java.util.HashSet;

/**
 * https://practice.geeksforgeeks.org/contest/dsasp-w3/problems
 */
public class XORPair {
     public static boolean pairExists(int[] arr, int n, int c){
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            int curr_xor = c ^ arr[i];
            
            if(set.contains(curr_xor)){
                return true;
            }else {
                set.add(arr[i]);
            }
        }
        
        return false;
    }
}
