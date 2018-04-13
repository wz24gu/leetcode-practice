package edu.wz.cs.leetcode.medium;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown<br>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown<br><br>
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.<br>
 * 
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and 
 * sell one share of the stock multiple times) with the following restrictions:<br>
 * 1. You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).<br>
 * 2. After you sell your stock, you cannot buy stock on next day. (i.e., cool down 1 day)
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    
    public static int solution(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int n = prices.length;        
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] rest = new int[n];        
        
        buy[0] = -prices[0];
        sell[0] = Integer.MIN_VALUE;
        rest[0] = 0;
        for (int i = 1; i < n; i++) {            
            buy[i] = Math.max(buy[i-1], rest[i-1] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
            rest[i] = Math.max(rest[i-1], sell[i-1]);
        }
        
        return Math.max(rest[n-1], sell[n-1]);
    }
    
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(BestTimeToBuyAndSellStockWithCooldown.solution(prices));
    }

}
