package DSA.Array.BuyAndSellStocks;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class BuyAndSellStocks1 {
    public int maxProfit(int[] A) {
	    int buy = Integer.MAX_VALUE;
        int sell = 0;

        for (int j : A) {
            buy = Math.min(buy, j);
            sell = Math.max(sell, j - buy);
        }
        return sell;
	    
	}
}
