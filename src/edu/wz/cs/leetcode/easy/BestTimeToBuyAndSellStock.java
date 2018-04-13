package edu.wz.cs.leetcode.easy;

/**
 * 121. Best Time to Buy and Sell Stock<br>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock<br><br>
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.<br>
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 */
public class BestTimeToBuyAndSellStock {
    
    public static int solution(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
    
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(BestTimeToBuyAndSellStock.solution(prices));
        
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(BestTimeToBuyAndSellStock.solution(prices2));
    }

}
