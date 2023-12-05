package DSA.Array.Sorting;

public class HIndex {
    /* Using count sort */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
    
    /**
     * Using Sorting & Binary Search
     public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int low=0,high=n-1,mid;
        
        while(low<=high)
        {
            mid = low+(high-low)/2;
            if(citations[mid]==(n-mid))
                return citations[mid];
            else if(citations[mid]>(n-mid))
                high = mid-1;
            else
                low = mid+1;
        }
        return n-low;
    }
     */
}
