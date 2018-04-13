package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 801. Minimum Swaps To Make Sequences Increasing<br>
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing<br><br>
 * 
 * We have two integer sequences A and B of the same non-zero length.<br>
 * 
 * We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their 
 * respective sequences.<br>
 * 
 * At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and 
 * only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)<br>
 * 
 * Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that 
 * the given input always makes it possible.<br><br>
 * 
 * Note:<br>
 * 1. A, B are arrays with the same length, and that length will be in the range [1, 1000].<br>
 * 2. A[i], B[i] are integer values in the range [0, 2000].
 */
public class MinimumSwapsToMakeSequencesIncreasing {
    
    public static int solution(int[] A, int[] B) {
        int n = A.length;
        int[] swap = new int[n];
        int[] fix = new int[n];
        swap[0] = 1;
        
        for (int i = 1; i < n; i++) {
            fix[i] = swap[i] = n;
            if (A[i-1] < A[i] && B[i-1] < B[i]) {
                fix[i] = fix[i-1];
                swap[i] = swap[i-1] + 1;
            }
            if (A[i-1] < B[i] && B[i-1] < A[i]) {
                fix[i] = Math.min(fix[i], swap[i-1]);
                swap[i] = Math.min(swap[i], fix[i-1] + 1);
            }
            System.out.println(Arrays.toString(fix));
            System.out.println(Arrays.toString(swap));
        }
        
        return Math.min(swap[n-1], fix[n-1]);
    }
    
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 4};
        int[] B = {1, 2, 3, 7};
        System.out.println(MinimumSwapsToMakeSequencesIncreasing.solution(A, B));
    }

}
