package DSA.Array.SlidingWindow;
import java.util.*;

public class ReverseInGroups {
    //Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        for(int i = 0; i < n; i += k){
            if(i+k < n){
                reverse(arr,n,i,i+k-1);
            } else {
                reverse(arr,n,i, n-1);
            }
        }
    }
    
    void reverse(ArrayList<Integer> arr, int n, int left, int right){
        while(left < right){
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            
            left += 1;
            right -= 1;
        }
    }
}
