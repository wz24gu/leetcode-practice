package edu.wz.cs.leetcode.medium;

/**
 * 91. Decode Ways<br>
 * https://leetcode.com/problems/decode-ways<br><br>
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:<br>
 * 'A' -> 1<br>
 * 'B' -> 2<br>
 * ...<br>
 * 'Z' -> 26<br>
 * Given an encoded message containing digits, determine the total number of ways to decode it.<br>
 * 
 * For example,<br>
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).<br>
 * The number of ways decoding "12" is 2.
 */
public class DecodeWays {
    
    public static int solution(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = (s.charAt(i-1) == '0') ? 0 : dp[i-1];
            if (i > 1 && (s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')) {
                dp[i] += dp[i-2];
            }
        }        
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(DecodeWays.solution("12"));
    }

}
