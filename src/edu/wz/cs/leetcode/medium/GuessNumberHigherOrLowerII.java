package edu.wz.cs.leetcode.medium;

/**
 * 375. Guess Number Higher or Lower II<br>
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii<br><br>
 * 
 * We are playing the Guess Game. The game is as follows:<br>
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.<br>
 * 
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.<br>
 * 
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the 
 * number I picked.<br>
 * 
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class GuessNumberHigherOrLowerII {
    
    public static int solution(int n) {
        int[][] dp = new int[n+1][n+1];
        
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j > 0; j--) {
                int global = Integer.MAX_VALUE;
                
                for (int k = j + 1; k < i; k++) {
                    int local = k + Math.max(dp[j][k-1], dp[k+1][i]);
                    global = Math.min(global, local);
                }
                dp[j][i] = j + 1 == i ? j : global;
            }
        }
        
        return dp[1][n];
    }
    
    public static void main(String[] args) {
        System.out.println(GuessNumberHigherOrLowerII.solution(1));
        System.out.println(GuessNumberHigherOrLowerII.solution(2));
        System.out.println(GuessNumberHigherOrLowerII.solution(3));
        System.out.println(GuessNumberHigherOrLowerII.solution(4));
    }

}
