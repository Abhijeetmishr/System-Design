package DSA.Graph.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SteppingNum {
    /*
     * Given A and B you have to find all stepping numbers in the range A to B (both inclusive).

        The stepping number:

        A number is called as a stepping number if the adjacent digits have a difference of 1.

        For e.g. 123 is a stepping number, but 358 is not a stepping number
        Example Input
        Input 1:

        A = 10
        B = 20
    <----------------------------------------------------->
        Example Output
        Output 1:

        [10, 12]
    */
    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i <= 9; i++){
            bfs(A, B, i, result);
        }
        Collections.sort(result);
        return result;
    }
     
    public void bfs(int A, int B, int num, ArrayList<Integer> result){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        while(!queue.isEmpty()){
            int steppingNum = queue.poll();
            
            if (steppingNum >= A && steppingNum <= B) {
                result.add(steppingNum);
            }

            if (steppingNum == 0 || steppingNum > B) {
                continue;
            }

            int lastDigit = steppingNum % 10;

            int stepNumA = steppingNum * 10 + lastDigit - 1;
            int stepNumB = steppingNum * 10 + lastDigit + 1;

            if (lastDigit == 0) {
                queue.offer(stepNumB);
            } else if (lastDigit == 9) {
                queue.offer(stepNumA);
            } else {
                queue.offer(stepNumA);
                queue.offer(stepNumB);
            }
        }
    }
}
