package edu.wz.cs.leetcode.easy;

/**
 * 7. Reverse Integer<br>
 * https://leetcode.com/problems/reverse-integer<br><br>
 * 
 * Given a 32-bit signed integer, reverse digits of an integer.<br>
 * 
 * Note: Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer 
 * range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    
    public static int solution(int n) {
        int result = 0;
        while (n != 0) {
            if (Math.abs(result) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + n % 10;
            n /= 10;
        }
        return result;
    }
    
    public static int solutionAlt(int n) {
        long result = 0;        
        while (n != 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        else {
            return (int) result;
        }        
    }
    
    public static void main(String[] args) {
        System.out.println(ReverseInteger.solution(123));
        System.out.println(ReverseInteger.solution(-123));
        System.out.println(ReverseInteger.solution(-2147483648));
        
        System.out.println(ReverseInteger.solutionAlt(123));
        System.out.println(ReverseInteger.solutionAlt(-123));
        System.out.println(ReverseInteger.solutionAlt(-2147483648));        
    }

}
