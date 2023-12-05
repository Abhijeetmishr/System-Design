package DSA.Stack;

import java.util.Stack;

public class MaximumSubarraySum {
    public static long solve(int[] arr) {
        long sum = 0;
        Stack<Integer> stack = new Stack<>();
        int[] leftCount = new int[arr.length];
        int[] rightCount = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            leftCount[i] = 0;
            rightCount[i] = 0;

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                leftCount[i] = stack.peek() + 1;
            }

            stack.push(i);

            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                rightCount[i] = arr.length - stack.peek() - 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sum += (leftCount[i] + 1) * (rightCount[i] + 1) * arr[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        long sum = solve(arr);
        System.out.println(sum);
    }
}

