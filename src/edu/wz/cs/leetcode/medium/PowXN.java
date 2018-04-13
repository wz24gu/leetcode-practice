package edu.wz.cs.leetcode.medium;

/**
 * 50. Pow(x, n)<br>
 * https://leetcode.com/problems/powx-n<br><br>
 * 
 * Implement pow(x, n).
 */
public class PowXN {

    public static double solution(double x, int n) {
        if (n < 0) {
            return 1 / solution(x, -n);
        }
        return helper(x, n);
    }
    
    private static double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        double half = helper(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        else {
            return x * half * half;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(PowXN.solution(2, 10));
    }
    
}
