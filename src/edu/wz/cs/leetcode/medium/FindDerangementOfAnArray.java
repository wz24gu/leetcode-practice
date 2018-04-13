package edu.wz.cs.leetcode.medium;

/**
 * 634. Find the Derangement of An Array<br>
 * https://leetcode.com/problems/find-the-derangement-of-an-array<br><br>
 * 
 * In combinatorial mathematics, a derangement is a permutation of the elements of a set, such that no element appears 
 * in its original position.<br>
 * 
 * There's originally an array consisting of n integers from 1 to n in ascending order, you need to find the number of 
 * derangement it can generate.<br>
 * 
 * Also, since the answer may be very large, you should return the output mod 10^9 + 7.<br>
 * 
 * Note: n is in the range of [1, 10^6].
 */
public class FindDerangementOfAnArray {
    
    public static int solution(int n) {
        if (n == 1) {
            return 0;
        }
        
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i-1] + dp[i-2]) % 1000000009;
        }
        return dp[n];
    }
    
    public static int solutionAlt(int n) {
        if (n == 1) {
            return 0;
        }
        
        int a = 0;
        int b = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = (i - 1) * (a + b) % 1000000009;
            a = b;
            b = result;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(FindDerangementOfAnArray.solution(3));
        System.out.println(FindDerangementOfAnArray.solutionAlt(3));
    }

}
