package edu.wz.cs.leetcode.medium;

/**
 * 795. Number of Subarrays with Bounded Maximum<br>
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum<br><br>
 * 
 * We are given an array A of positive integers, and two positive integers L and R (L <= R).<br>
 * 
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that 
 * subarray is at least L and at most R.<br><br>
 * 
 * Note:<br>
 * 1. L, R  and A[i] will be an integer in the range [0, 10^9].<br>
 * 2. The length of A will be in the range of [1, 50000].
 */
public class NumberOfSubarraysWithBoundedMaximum {
    
    public static int solution(int[] A, int L, int R) {
        int res = 0;
        int count = 0;
        int i = 0;
        for (int j = 0; j < A.length; j++) {
            if (A[j] >= L && A[j] <= R) {
                count = j - i + 1;
                res += count;
            }
            else if (A[j] < L) {
                res += count;
            }
            else {
                count = 0;
                i = j + 1;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = {2, 1, 4, 3};
        System.out.println(NumberOfSubarraysWithBoundedMaximum.solution(A, 2, 3));
    }

}
