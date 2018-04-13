package edu.wz.cs.leetcode.hard;

/**
 * 123. Best Time to Buy and Sell Stock III<br>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii<br><br>
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.<br>
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.<br>
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII {
    
    public static int solution(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int n = prices.length;
        int[][] local = new int[n][2+1];
        int[][] global = new int[n][2+1];
        
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i-1];
            for (int j = 1; j <= 2; j++) {
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff, 0), local[i-1][j] + diff);
                global[i][j] = Math.max(local[i][j], global[i-1][j]);
            }
        }
        
        return global[n-1][2];
    }
    
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 9};
        System.out.println(BestTimeToBuyAndSellStockIII.solution(prices));
    }

}
