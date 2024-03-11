package DSA.Array;

/**
 *  Sample Input 1
    3
    1 1 1

    Sample Output 1
    112

    Explanation
    111 + 1 = 112
 */
public class IncrementByOne {

    public int[] increment(int n, int[] arr){
        for(int i = n-1; i >= 0; i--){
            if(arr[i] == 9){
                arr[i] = 0;
            }else {
                arr[i]++;
                return arr;
            }
        }

        int[] ans = new int[n+1];
        ans[0] = 1;
        return ans;
    }
}
