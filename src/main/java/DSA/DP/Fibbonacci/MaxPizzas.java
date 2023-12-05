package DSA.DP.Fibbonacci;

public class MaxPizzas {

    /*
    How can we maximize the number of pizzas picked from a set of pizza bowls,
    each containing a certain number of pizzas? The constraint is that we cannot pick two consecutive bowls.
    As an example, given the input of pizza bowl sizes: [5, 3, 4, 11, 1], what would be the output, representing
    the maximum number of pizzas that can be obtained following the specified constraint? 
    */
    public static int maxPizzas(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }

        // Initialize an array to store the maximum number of pizzas for each bowl
        int[] dp = new int[n];

        // Set the base cases
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        // Fill in the dp array using the recurrence relation
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }

        // The result is the maximum of the last two entries in the dp array
        return Math.max(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        int[] inputPizzas = {5, 3, 4, 11, 1};
        int output = maxPizzas(inputPizzas);
        System.out.println(output);
    }
}

