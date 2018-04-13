package edu.wz.cs.leetcode.medium;

/**
 * 813. Largest Sum of Averages<br>
 * https://leetcode.com/problems/largest-sum-of-averages<br><br>
 * 
 * We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of the average 
 * of each group. What is the largest score we can achieve?<br>
 * 
 * Note that our partition must use every number in A, and that scores are not necessarily integers.<br>
 * 
 * Note:<br>
 * 1. 1 <= A.length <= 100.<br>
 * 2. 1 <= A[i] <= 10000.<br>
 * 3. 1 <= K <= A.length.<br>
 * 4. Answers within 10^-6 of the correct answer will be accepted as correct.
 */
public class LargestSumOfAverages {
    
    public static double solution(int[] A, int k) {
        int n = A.length;
        double[][] dp = new double[n+1][n+1];
        double curr = 0;
        
        for (int i = 0; i < n; i++) {
            curr += A[i];
            dp[i+1][1] = curr / (i + 1);
        }
        
        return search(n, k, A, dp);
    }
    
    private static double search(int n, int k, int[] A, double[][] dp) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }
        
        double curr = 0;
        for (int i =  n - 1; i > 0; i--) {
            curr += A[i];
            dp[n][k] = Math.max(dp[n][k], search(i, k - 1, A, dp) + curr / (n - i));
        }
        return dp[n][k];
    }
    
    public static void main(String[] args) {
        int[] A = {9, 1, 2, 3, 9};
        System.out.println(LargestSumOfAverages.solution(A, 3));
    }

}
