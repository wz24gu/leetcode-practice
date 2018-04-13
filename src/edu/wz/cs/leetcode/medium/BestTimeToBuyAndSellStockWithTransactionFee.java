package edu.wz.cs.leetcode.medium;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee<br>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee<br>
 * 
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a
 * non-negative integer fee representing a transaction fee.<br>
 * 
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You 
 * may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)<br>
 * 
 * Return the maximum profit you can make.<br><br>
 * 
 * Note:<br>
 * 1. 0 < prices.length <= 50000.<br>
 * 2. 0 < prices[i] < 50000.<br>
 * 3. 0 <= fee < 50000.
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    
    public static int solution(int[] prices, int fee) {
        int n = prices.length;        
        int[] sell = new int[n];
        int[] buy = new int[n];
        buy[0] = -prices[0];
        
        for (int i = 1; i < n; i++) {
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i] - fee);
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);
        }
        return Math.max(sell[n-1], buy[n-1]);
    }
    
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(BestTimeToBuyAndSellStockWithTransactionFee.solution(prices, 2));
    }

}
