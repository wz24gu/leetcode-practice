package edu.wz.cs.leetcode.hard;

/**
 * 639. Decode Ways II<br>
 * https://leetcode.com/problems/decode-ways-ii<br><br>
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:<br>
 * 1. 'A' -> 1<br>
 * 2. 'B' -> 2<br>
 * 3. 'Z' -> 26<br>
 * 
 * Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers 
 * from 1 to 9.<br>
 * 
 * Given the encoded message containing digits and the character '*', return the total number of ways to decode it.<br>
 * 
 * Also, since the answer may be very large, you should return the output mod 10^9 + 7.<br>
 * 
 * Note:<br>
 * 1. The length of the input string will fit in range [1, 10^5].<br>
 * 2. The input string will only contain the character '*' and digits '0' - '9'.
 */
public class DecodeWaysII {
    
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int M = 1000000007;
        int n = s.length();
        long[] dp = new long[n+1];        
        dp[0] = 1;
        
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[1] = (s.charAt(0) == '*') ? 9 : 1;
        
        for (int i = 2; i <= n; i++) {
            char prepre = s.charAt(i-2);
            char pre = s.charAt(i-1);
            
            if (pre == 0) {
                if (prepre == '1' || prepre == '2') {
                    dp[i] += dp[i-2];
                }
                else if (prepre == '*') {
                    dp[i] += 2 * dp[i-2];
                }
                else {
                    return 0;
                }
            }
            else if (pre >= '1' && pre <= '9') {
                dp[i] += dp[i-1];
                if (prepre == '1' || (prepre == '2' && pre <= '6')) {
                    dp[i] += dp[i-2];
                }
                else if (prepre == '*') {
                    dp[i] += (pre <= '6') ? dp[i-2] * 2 : dp[i-2];
                }
            }
            else {  // c == '*'
                dp[i] += dp[i-1] * 9;
                if (prepre == '1') {
                    dp[i] += dp[i-2] * 9;
                }
                else if (prepre == '2') {
                    dp[i] += dp[i-2] * 6;
                }
                else if (prepre == '*') {
                    dp[i] += dp[i-2] * 15;
                }
            }
            
            dp[i] %= M;
        }
        
        return (int) dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(DecodeWaysII.solution("*"));
        System.out.println(DecodeWaysII.solution("1*"));
    }

}
