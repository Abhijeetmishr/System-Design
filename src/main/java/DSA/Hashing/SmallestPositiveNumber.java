package DSA.Hashing;
import java.util.*;
public class SmallestPositiveNumber {
    static int missingNumber(int arr[], int size)
    {
        HashSet<Integer> set = new HashSet<>();
        
        for(int ele: arr){
            set.add(ele);
        }
        
        for(int i = 1; i <= size+1; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return size+1;
    }
}
