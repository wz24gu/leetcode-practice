package edu.wz.cs.leetcode.medium;

/**
 * 718. Maximum Length of Repeated Subarray<br>
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray<br><br>
 * 
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.<br><br>
 * 
 * Note:<br>
 * 1. 1 <= len(A), len(B) <= 1000<br>
 * 2. 0 <= A[i], B[i] < 100
 */
public class MaximumLengthOfRepeatedSubarray {
    
    public static int solution(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m+1][n+1];
        
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (A[i-1] == B[j-1]) ? dp[i-1][j-1] + 1 : 0;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        System.out.println(MaximumLengthOfRepeatedSubarray.solution(A, B));
    }

}
