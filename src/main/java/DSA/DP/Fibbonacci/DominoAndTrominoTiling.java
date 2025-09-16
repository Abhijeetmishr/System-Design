package DSA.Fibbonacci;
import java.util.Scanner;

// https://leetcode.com/problems/domino-and-tromino-tiling/solutions/116581/detail-and-explanation-of-o-n-solution-why-dp-n-2-d-n-1-dp-n-3
public class DominoAndTrominoTiling {
     public int numTilings(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        int dp[] = new int[n+1];
        dp[0] = 1; dp[1] = 1; dp[2] = 2; dp[3] = 5;

        int md=1000000007;

        for(int i = 4; i <= n; i++) {
             dp[i] = (int)((2L * dp[i-1] + dp[i-3]) % md);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DominoAndTrominoTiling obj = new DominoAndTrominoTiling();
        int ans = obj.numTilings(n);
        System.out.println(ans);
    }
}