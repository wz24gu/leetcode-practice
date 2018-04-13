package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 446. Arithmetic Slices II - Subsequence<br>
 * https://leetcode.com/problems/arithmetic-slices-ii-subsequence<br><br>
 * 
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between 
 * any two consecutive elements is the same.<br>
 * 
 * A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is any sequence of integers 
 * (P0, P1, ..., Pk) such that 0 <= P0 < P1 < ... < Pk < N.<br>
 * 
 * A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], 
 * A[Pk] is arithmetic. In particular, this means that k >= 2.<br>
 * 
 * The function should return the number of arithmetic subsequence slices in the array A.<br>
 * 
 * The input contains N integers. Every integer is in the range of -2^31 and 2^31-1 and 0 <= N <= 1000. The output is 
 * guaranteed to be less than 2^31-1.
 */
public class ArithmeticSlicesII {
    
    @SuppressWarnings("unchecked")
    public static int solution(int[] A) {
        int n = A.length;
        Map<Integer, Integer>[] dp = (Map<Integer, Integer>[])new Map[n];
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<Integer, Integer>(i);
            
            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                
                int d = (int) diff;
                if (!dp[i].containsKey(d)) {
                    dp[i].put(d, 1);
                }
                if (dp[j].containsKey(d)) {
                    dp[i].put(d, dp[i].get(d) + dp[j].get(d));
                    result += dp[j].get(d);
                }
                
                /*
                int c1 = dp[i].getOrDefault(d, 0);
                int c2 = dp[j].getOrDefault(d, 0);
                result += c2;
                dp[i].put(d, c1 + c2 + 1);
                */
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] A = {2, 4, 6, 8, 10};
        System.out.println(ArithmeticSlicesII.solution(A));
    }

}
