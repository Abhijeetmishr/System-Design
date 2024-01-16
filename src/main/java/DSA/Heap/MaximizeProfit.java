package DSA.Heap;
import java.util.*;

/**
 * https://www.geeksforgeeks.org/maximize-the-profit-after-selling-the-tickets/
 */
public class MaximizeProfit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        long res = maxKProfit(n, b, a);

        System.out.println(res);
    }

    static long maxKProfit(int N, int B, int[] a) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++) {
            queue.add(a[i]);
        }
        long profit = 0;
        int count = 0;

        while (count < B) {
            int top = queue.remove();

            if (top == 0) {
                break;
            }
            profit  = profit + top;
            queue.add(top-1);
            count++;
        }
        return profit;
    }
}
