package DSA.DP.Unbounded_Knapsack;

import java.util.Scanner;

class RodCutting{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int price[]=new int[n];
        for(int i=0;i<n;i++)
        {
            price[i]=sc.nextInt();
        }
        System.out.println(rodCutting(n, price));
        sc.close();
    }

    static int rodCutting(int n, int price[]){
        int[][] dp = new int[n + 1][n+1];
        int[] length = new int[n+1];
        for(int i = 0; i <= n; i++){
            length[i] = i+1;
        }

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if(length[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }
}
