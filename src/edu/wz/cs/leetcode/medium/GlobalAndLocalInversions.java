package edu.wz.cs.leetcode.medium;

/**
 * 775. Global and Local Inversions<br>
 * https://leetcode.com/problems/global-and-local-inversions<br><br>
 * 
 * We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.<br>
 * 
 * The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].<br>
 * 
 * The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].<br>
 * 
 * Return true if and only if the number of global inversions is equal to the number of local inversions.<br><br>
 *  
 * Note:<br>
 * 1. A will be a permutation of [0, 1, ..., A.length - 1].<br>
 * 2. A will have length in range [1, 5000].<br>
 * 3. The time limit for this problem has been reduced.
 */
public class GlobalAndLocalInversions {
    
    public static boolean solution(int[] A) {
        int max = -1;
        for (int i = 0; i < A.length - 2; i++) {
            max = Math.max(max, A[i]);
            if (max > A[i+2]) {
                return false;
            }
        }
        return true;   
    }
    
    public static void main(String[] args) {
        int[] A = {1, 0, 2};
        System.out.println(GlobalAndLocalInversions.solution(A));
        
        int[] A2 = {1, 2, 0};
        System.out.println(GlobalAndLocalInversions.solution(A2));
    }

}
