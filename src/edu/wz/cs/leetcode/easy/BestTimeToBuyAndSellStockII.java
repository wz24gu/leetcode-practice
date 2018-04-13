package edu.wz.cs.leetcode.easy;

/**
 * 122. Best Time to Buy and Sell Stock II<br>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii<br><br>
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.<br>
 * 
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and 
 * sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time 
 * (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII {
    
    public static int solution(int[] prices) {        
        int profit = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
    
    public static void main(String[] args) {
        int[] prices = { 2, 4, 7, 3, 3, 1, 5, 7};
        System.out.println(BestTimeToBuyAndSellStockII.solution(prices));
    }

}
