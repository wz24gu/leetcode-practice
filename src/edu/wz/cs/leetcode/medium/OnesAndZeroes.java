package edu.wz.cs.leetcode.medium;

/**
 * 474. Ones and Zeroes<br>
 * https://leetcode.com/problems/ones-and-zeroes<br><br>
 * 
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.<br>
 * 
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings 
 * consisting of only 0s and 1s.<br>
 * 
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can 
 * be used at most once.<br><br>
 * 
 * Note:<br>
 * 1. The given numbers of 0s and 1s will both not exceed 100<br>
 * 2. The size of given string array won't exceed 600.
 */
public class OnesAndZeroes {
    
    public static int solution(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String s : strs) {
            int zero = 0;
            int one = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zero++;
                }
                else if (c == '1') {
                    one++;
                }
            }
            
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zero][j-one] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(OnesAndZeroes.solution(strs, 5, 3));
        
        String[] strs2 = {"10", "0", "1"};
        System.out.println(OnesAndZeroes.solution(strs2, 1, 1));
    }

}
