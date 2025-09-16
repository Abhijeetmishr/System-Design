package DSA.Stack;

import java.util.Stack;

// Decreasing Monotonic Stack
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
            span[i] = i - stack.pop();
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


// Decreasing Monotonic Stack
class StockSpanner {
//    Initialize a stack with int array.
//      First Index would be price, and
//      Second Index Will be span at that price.
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
//        At each level initialize the span to 1.
        int span = 1;
//        If The top element of stack price is below or equal to the current price:
//          Then, the previous element will be span of current.
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            span += stack.pop()[1];
        }
//        At each level add the price and the span. 
//        So that Next time when visited for consecutive days, you have the value of current that will avoid traversal till the current days span. 
        stack.add(new int[]{price, span});
        return span;
    }
}

