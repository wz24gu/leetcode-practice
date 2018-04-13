package edu.wz.cs.leetcode.medium;

/**
 * 396. Rotate Function<br>
 * https://leetcode.com/problems/rotate-function<br><br>
 * 
 * Given an array of integers A and let n to be its length. Assume Bk to be an array obtained by rotating the array Ak 
 * positions clock-wise, we define a "rotation function" F on A as follow:<br>
 * 
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].<br>
 * 
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).<br>
 * 
 * Note: n is guaranteed to be less than 105.
 */
public class RotateFunction {
    
    // F(i) = F(i-1) + sum - n * A[n-i]
    public static int solution(int[] A) {
        int n = A.length;
        int sum = 0;
        int t = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            t += i * A[i];
        }
        
        int result = t;
        for (int i = 1; i < n; i++) {
            t = t + sum - n * A[n-i];
            result = Math.max(result, t);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6};
        System.out.println(RotateFunction.solution(A));
    }

}
