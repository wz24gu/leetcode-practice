package edu.wz.cs.leetcode.medium;

/**
 * 518. Coin Change 2<br>
 * https://leetcode.com/problems/coin-change-2<br><br>
 * 
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of 
 * combinations that make up that amount. You may assume that you have infinite number of each kind of coin.<br><br>
 * 
 * Note: You can assume that<br>
 * 1. 0 <= amount <= 5000<br>
 * 2. 1 <= coin <= 5000<br>
 * 3. the number of coins is less than 500<br>
 * 4. the answer is guaranteed to fit into signed 32-bit integer
 */
public class CoinChangeII {
    
    public static int solution(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount+1][n+1];
        
        dp[0][0] = 1;
        for (int i = 1; i < amount + 1; i++) {
            dp[i][0] = 0;  // 0 coins, 0 solution
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = 1;  // 0 amount, 1 solution
        }
        
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i][j-1];
                if (coins[j-1] <= i) {
                    dp[i][j] += dp[i - coins[j-1]][j];
                }
            }
        }
        
        return dp[amount][n];
    }
    
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(CoinChangeII.solution(5, coins));
        
        int[] coins2 = {2};
        System.out.println(CoinChangeII.solution(3, coins2));
        
        int[] coins3 = {10};
        System.out.println(CoinChangeII.solution(10, coins3));
    }

}
