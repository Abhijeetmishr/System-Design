package DSA.Array.BinarySearch;

/*
 * https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
 */
public class AllocateMinimumPages {
    
    public int minPages(int[] arr, int n, int k){
        int sum = 0, mx = 0;

        for(int i = 0; i < n; i++){
            mx = Math.max(mx, arr[i]);
            sum += arr[i];
        }

        int res = 0, low = mx, high = sum;

        while(low <= high){
            int mid = (low+high)/2;
            if(isFeasible(arr,n,k,mid)){
                res = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return res;
    }

    public boolean isFeasible(int[] arr, int n, int k, int ans){
        int req = 1, sum = 0;
        for(int i = 0; i < n; i++){
            if(sum + arr[i] > ans){
                req++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return (req <= k);
    }
}
