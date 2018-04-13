package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 322. Coin Change<br>
 * https://leetcode.com/problems/coin-change<br><br>
 * 
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the 
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any 
 * combination of the coins, return -1.<br>
 * 
 * Note: You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    
    public static int solution(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0;
        int n = coins.length;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(CoinChange.solution(coins, 11));
        
        int[] coins2 = {2};
        System.out.println(CoinChange.solution(coins2, 3));
    }

}
