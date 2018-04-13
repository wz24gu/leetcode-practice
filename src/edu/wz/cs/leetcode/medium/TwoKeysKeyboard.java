package edu.wz.cs.leetcode.medium;

/**
 * 650. 2 Keys Keyboard<br>
 * https://leetcode.com/problems/2-keys-keyboard<br><br>
 * 
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each 
 * step:<br>
 * 1. Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).<br>
 * 2. Paste: You can paste the characters which are copied last time.<br>
 * 
 * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. 
 * Output the minimum number of steps to get n 'A'.<br>
 * 
 * Note: The n will be in the range [1, 1000].
 */
public class TwoKeysKeyboard {
    
    public static int solution(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(TwoKeysKeyboard.solution(1));
        System.out.println(TwoKeysKeyboard.solution(2));
        System.out.println(TwoKeysKeyboard.solution(3));
        System.out.println(TwoKeysKeyboard.solution(6));
        System.out.println(TwoKeysKeyboard.solution(9));
    }

}
