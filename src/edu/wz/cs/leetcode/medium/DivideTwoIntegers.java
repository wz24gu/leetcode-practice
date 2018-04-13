package edu.wz.cs.leetcode.medium;

/**
 * 29. Divide Two Integers<br>
 * https://leetcode.com/problems/divide-two-integers<br><br>
 * 
 * Divide two integers without using multiplication, division and mod operator.<br>
 * 
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
    
    public static int solution(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        int sign = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            sign = -1;
        }
        
        long dvd = (long) Math.abs(dividend);
        long dvs = (long) Math.abs(divisor);
        int res = 0;
        
        while (dvd >= dvs) {
            long tmp = dvs;
            long time = 1;
            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                time <<= 1;
            }
            dvd -= tmp;
            res += time;
        }
        
        return sign == 1 ? res : -res;
    }
    
    public static void main(String[] args) {
        System.out.println(DivideTwoIntegers.solution(15, 3));
    }

}
