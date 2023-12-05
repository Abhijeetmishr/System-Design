package DSA.Stack;

import java.util.Stack;

public class StockSpan {
    /*
        Input: 
        N = 7, price[] = [100 80 60 70 60 75 85]
        Output:
        1 1 1 2 1 4 6
        Explanation:
        Traversing the given input span for 100 
        will be 1, 80 is smaller than 100 so the 
        span is 1, 60 is smaller than 80 so the 
        span is 1, 70 is greater than 60 so the 
        span is 2 and so on. Hence the output will 
        be 1 1 1 2 1 4 6.
    */

   //Function to calculate the span of stockâ€™s price for all n days.
   public static int[] calculateSpan(int price[], int n){
      Stack<Integer> stack = new Stack<>();
      int[] span = new int[n];

      span[0] = 1;
      stack.push(0);

      for(int i = 1; i < n; i++){
        while(!stack.isEmpty() && price[i] >= price[stack.peek()]){
            stack.pop();
        }
        if(stack.isEmpty()){
            span[i] = i + 1;
        } else{
            span[i] = i - stack.peek();
        }
        stack.push(i);
      }
      return span;
    }
    
    public static void main(String[] args) {
        int N = 7;
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(arr, N);
        for(int x: span){
            System.out.print(x + " ");
        }
    }
}
