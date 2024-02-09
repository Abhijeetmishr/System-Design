package DSA.Greedy;
import java.util.*;

public class ActivitySelection {
    static int activitySelection(int n, int start[], int end[]){
        
        int[][] pair = new int[n][2];
        for(int s = 0; s < n; s++){
            pair[s] = new int[]{start[s], end[s]};
        }
        Arrays.sort(pair, (p1, p2) -> p1[1] - p2[1]);

        int activity = 1;
        int end_prev = 0;
        for(int curr = 1; curr < n; curr++){
            if(pair[curr][0] >= pair[end_prev][1]){
                activity += 1;
                end_prev = curr;
            }
        }        
        return activity;
    }
}
