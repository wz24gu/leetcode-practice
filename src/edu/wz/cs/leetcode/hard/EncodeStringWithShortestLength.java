package edu.wz.cs.leetcode.hard;

/**
 * 471. Encode String with Shortest Length<br/>
 * 
 * Given a non-empty string, encode the string such that its encoded length is the shortest. The encoding rule is:
 * k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.<br/><br/>
 * 
 * Note:<br/>
 * 1. k will be a positive integer and encoded string will not be empty or have extra space.<br/>
 * 2. You may assume that the input string contains only lowercase English letters. The string's length is at most 160.<br/>
 * 3. If an encoding process does not make the string shorter, then do not encode it. If there are several solutions,
 * return any of them is fine.
 */
public class EncodeStringWithShortestLength {
    
    public static String solution(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        
        int n = str.length();
        String[][] dp = new String[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = str.charAt(i) + "";
        }
        
        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                // enumerate k
                for (int k = i; k < j; k++) {
                    int left = dp[i][k].length();
                    int right = dp[k+1][j].length();
                    if (dp[i][j] == null || left + right < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k+1][j];
                    }
                }
                
                // encode string in (i, j)
                String sub = str.substring(i, j + 1);
                int index = (sub + sub).indexOf(sub, 1);
                if (index < sub.length()) {
                    sub = (sub.length() / index) + "[" + dp[i][i+index-1] + "]";
                }
                if (dp[i][j] == null || sub.length() < dp[i][j].length()) {
                    dp[i][j] = sub;
                }
            }
        }
        
        return dp[0][n-1];
    }
    
    public static void main(String[] args) {
        System.out.println(EncodeStringWithShortestLength.solution("aaa"));
        System.out.println(EncodeStringWithShortestLength.solution("aaaaa"));
        System.out.println(EncodeStringWithShortestLength.solution("aaaaaaaaaa"));
        System.out.println(EncodeStringWithShortestLength.solution("aabcaabcd"));
        System.out.println(EncodeStringWithShortestLength.solution("abbbabbbcabbbabbbc"));
    }

}
