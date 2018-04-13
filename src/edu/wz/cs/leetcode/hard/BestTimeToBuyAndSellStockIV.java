package edu.wz.cs.leetcode.hard;

/**
 * 188. Best Time to Buy and Sell Stock IV<br>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv<br><br>
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.<br>
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.<br>
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIV {
    
    public static int solution(int[] prices, int k) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int n = prices.length;
        if (k >= n) {
            return maxProfit(prices);
        }
        
        int[] global = new int[k+1];
        int[] local = new int[k+1];
        for (int i = 0; i < n - 1; i++) {
            int diff = prices[i+1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j-1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
    }
    
    private static int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

}
