package edu.wz.cs.leetcode.hard;

/**
 * 629. K Inverse Pairs Array<br>
 * https://leetcode.com/problems/k-inverse-pairs-array<br><br>
 * 
 * Given two integers n and k, find how many different arrays consist of numbers from 1 to n such that there are exactly 
 * k inverse pairs.<br>
 * 
 * We define an inverse pair as following: For ith and jth element in the array, if i < j and a[i] > a[j] then it's an 
 * inverse pair; Otherwise, it's not.<br>
 * 
 * Since the answer may be very large, the answer should be modulo 10^9 + 7.<br>
 * 
 * Note: The integer n is in the range [1, 1000] and k is in the range [0, 1000].
 */
public class KInversePairsArray {
    
    public static int solution(int n, int k) {
        int M = 1000000007;
    
        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                if (j >= i) {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j] - dp[i-1][j-i]) % M;
                }
                else {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % M;
                }
            }
        }
        
        return dp[n][k];
    }
    
    public static void main(String[] args) {
        System.out.println(KInversePairsArray.solution(3, 0));
        System.out.println(KInversePairsArray.solution(3, 1));
    }

}
