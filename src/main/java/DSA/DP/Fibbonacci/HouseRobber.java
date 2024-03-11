package DSA.DP.Fibbonacci;

import java.util.Scanner;

public class HouseRobber {
    public static long houseThief(int n, int []arr) {
		if(n == 0) return 0;
		if(n == 1) return arr[0];
		if(n == 2) return Math.max(arr[0], arr[1]);
		long[] dp = new long[n];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[1], arr[0]);

		for(int i = 2; i < n; i++){
			dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]);
		}
		return dp[n-1];
	}
	public static void main(String []args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int [n];
		for ( int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		long ans = houseThief(n, arr);
		System.out.println(ans);

	}
}
