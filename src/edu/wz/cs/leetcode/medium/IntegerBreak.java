package edu.wz.cs.leetcode.medium;

/**
 * 343. Integer Break<br>
 * https://leetcode.com/problems/integer-break<br><br>
 * 
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of 
 * those integers. Return the maximum product you can get.<br>
 * 
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).<br>
 * 
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak {
    
    public static int solution(int n) {        
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        return result * n;
    }
    
    public static void main(String[] args) {
        System.out.println(IntegerBreak.solution(10));
    }

}
