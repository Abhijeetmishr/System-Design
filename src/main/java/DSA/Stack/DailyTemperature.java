package DSA.Stack;
import java.util.*;

// Increaing Monotonic Stack
public class DailyTemperature {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && temp[i] > temp[st.peek()]){
                int idx = st.peek();
                ans[idx] = i - idx;
                st.pop(); 
            }
            st.push(i);
        }
        return ans;
    }
}
