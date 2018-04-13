package edu.wz.cs.leetcode.medium;

/**
 * 413. Arithmetic Slices<br>
 * https://leetcode.com/problems/arithmetic-slices<br><br>
 * 
 * A sequence of number is called arithmetic if it consists of at least 3 elements and if the difference between any 2
 * consecutive elements is the same. For example, these are arithmetic sequence:<br>
 * 1, 3, 5, 7, 9<br>
 * 7, 7, 7, 7<br>
 * 3, -1, -5, -9<br>
 * 
 * The following sequence is not arithmetic:<br>
 * 1, 1, 2, 5, 7<br>
 * 
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such
 * that 0 <= P < Q < N. A slice (P, Q) of array A is called arithmetic if the sequence A[P], A[P+1] .. A[Q] is arithmetic.
 * In particular, this means that P + 1 < Q.<br>
 * 
 * The function should return the number of arithmetic slices in the array A.
 */
public class ArithmeticSlices {

    public static int solution(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        
        int result = 0;
        int len = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                len++;
            }
            else {
                if (len > 2) {
                    result += (len - 1) * (len - 2) / 2;
                }
                len = 2;
            }
        }
        
        if (len > 2) {
            result += (len - 1) * (len - 2) / 2;  // take care of the last slice
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        System.out.println(ArithmeticSlices.solution(A));
    }

}
