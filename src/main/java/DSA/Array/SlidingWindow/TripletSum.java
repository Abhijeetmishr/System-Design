package DSA.Array.SlidingWindow;
import java.util.*;
public class TripletSum {

    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public boolean findTriplets(int arr[] , int n){
        Arrays.sort(arr);
        for(int i = 0; i < n-2; i++){
            int x = arr[i];
            int start = i+1;
            int end = n-1;

            while(start < end){
                if(x + arr[start] + arr[end] == 0){
                    return true;
                } else if(x + arr[start] + arr[end] < 0){
                    start++;
                } else {
                    end--;
                }
            }
        }
        return false;
    }
}
