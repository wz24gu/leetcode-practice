package edu.wz.cs.leetcode.medium;

/**
 * 651. 4 Keys Keyboard<br>
 * https://leetcode.com/problems/4-keys-keyboard<br><br>
 * 
 * Imagine you have a special keyboard with the following keys:<br>
 * 1. Key 1: (A): Print one 'A' on screen.<br>
 * 2. Key 2: (Ctrl-A): Select the whole screen.<br>
 * 3. Key 3: (Ctrl-C): Copy selection to buffer.<br>
 * 4. Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.<br>
 * 
 * Now, you can only press the keyboard for N times (with the above four keys), find out the maximum numbers of 'A' you 
 * can print on screen.<br><br>
 * 
 * Note:<br>
 * 1. 1 <= N <= 50<br>
 * 2. Answers will be in the range of 32-bit signed integer.
 */
public class FourKeysKeyboard {
    
    public static int solution(int n) {
        int max = n;  // N step can print at least N 'A'        
        for (int i = 1; i <= n - 3; i++) {
            max = Math.max(max, solution(i) * (n - i - 1));
        }
        return max;
    }    
    
    public static int solutionDP(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;  // N step can print at least N 'A'
            for (int j = 1; j <= i - 3; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(FourKeysKeyboard.solution(3));
        System.out.println(FourKeysKeyboard.solutionDP(3));
        System.out.println(FourKeysKeyboard.solution(7));
        System.out.println(FourKeysKeyboard.solutionDP(7));
    }

}
