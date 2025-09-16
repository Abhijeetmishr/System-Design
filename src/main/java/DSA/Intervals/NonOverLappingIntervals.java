package DSA.Intervals;

import java.util.Arrays;

public class NonOverLappingIntervals {
    /*
        Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
        Output: 1
        Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
    */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        // Sort the intervals based on the end coordinate
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int nonOverlapCount = 1; // At least one interval is non-overlapping
        int end = intervals[0][1]; // End of the first interval
        
        for(int i = 1; i < intervals.length; i++){
            // If the start of the current interval is greater than or equal to the end of the last selected interval
            if(intervals[i][0] >= end){
                nonOverlapCount++; // Count this interval as non-overlapping
                end = intervals[i][1]; // Update the end to the current interval's end
            }
        }
        // The number of intervals to remove is total intervals minus non-overlapping intervals
        return intervals.length - nonOverlapCount;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals)); // Output: 1
    }
}