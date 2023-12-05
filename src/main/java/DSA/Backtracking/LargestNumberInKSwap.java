package DSA.Backtracking;
import java.util.*;

//Function to find the largest number after k swaps.
/**
 *  Input:
    K = 4
    str = "1234567"
    Output:
    7654321

    <---------------------------------------->

    Input:
    K = 3
    str = "3435335"
    Output:
    5543333
*/
public class LargestNumberInKSwap {
    String max = "";
    public String findMaximumNum(String str, int k){
        char arr[] = str.toCharArray();
        max = str;
        int n = arr.length;
        helper(0, k, arr, n);
        return max;
    }

    public void helper(int swapCount, int k, char arr[], int n){
        if(swapCount == k) return;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] < arr[j]){
                    swap(i, j, arr);
                    if(String.valueOf(arr).compareTo(max) > 0)
                        max = String.valueOf(arr);
                    helper(swapCount+1, k, arr, n);
                    swap(j, i, arr);
                }
            }
        }
    }

    public void swap(int i, int j, char[] arr){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
class Test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int k = sc.nextInt();
            String str = sc.next();
            LargestNumberInKSwap obj = new LargestNumberInKSwap();
            System.out.println(obj.findMaximumNum(str, k));
        }
    }
}