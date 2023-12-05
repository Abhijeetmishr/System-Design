package DSA.Stack;

import java.util.Stack;

public class NextGreaterElement {
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        // ArrayDeque<Long> deque = new ArrayDeque<>();
        // deque.push(arr[arr.length-1]);
        // arr[n-1] = -1;
        // int i = n - 2;
        // while(i >= 0) {
        //     if(!deque.isEmpty() && deque.peek() > arr[i]) {
        //         long temp = deque.peek();
        //         deque.push(arr[i]);
        //         arr[i] = temp;
        //         i--;
        //     } else {
        //         if(!deque.isEmpty()) {
        //             deque.pop();
        //         } else {
        //             deque.push(arr[i]);
        //             arr[i] = -1;
        //             i--;
        //         }
        //     }
        // }
    
        // return arr;
        
        /*
            Input: 
            N = 4, arr[] = [1 3 2 4]
            Output:
            3 4 4 -1
        */

        Stack<Long> s = new Stack<>();              
        long nge[] = new long[n]; 
        
        //traversing the array from last element in backward direction.
        for (int i = n - 1; i >= 0; i--)
        {     
            if (!s.empty()) 
            {              
                //while element at top of stack is less than or equal to
                //current array element, we pop elements from the stack.
                while (!s.empty() && s.peek() <= arr[i]) {
                    s.pop();                              
                } 
            } 
            //if stack becomes empty, we store -1 in the answer list 
            //else we store the top element of the stack.   
            nge[i] = s.empty() ? -1 : s.peek();  
            
            //pushing the current array element into the stack.
            s.push(arr[i]);                     
        } 
        //returning the list.
        return nge;
    }
}
