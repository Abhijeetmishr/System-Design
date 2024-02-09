package DSA.Backtracking;

import java.util.ArrayList;

public class GenerateParanthesis {
    ArrayList<String> balancedBraces(int n) {
        ArrayList<String> output = new ArrayList<>();
        backtrack(output, "", 0, 0, n);
        return output;
    }

    public void backtrack(ArrayList<String> output, String ans, int open, int close, int max){
        if(ans.length() == max*2){
            output.add(ans);
            return;
        }
        if(open < max) backtrack(output, ans + "(", open+1, close, max);
        if(close < open) backtrack(output, ans + ")", open, close+1, max);
    }
}
