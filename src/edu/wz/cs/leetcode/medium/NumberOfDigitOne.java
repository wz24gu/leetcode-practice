package edu.wz.cs.leetcode.medium;

/**
 * 233. Number of Digit One<br>
 * https://leetcode.com/problems/number-of-digit-one<br><br>
 * 
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.<br>
 * 
 * Hint: Beware of overflow.
 */
public class NumberOfDigitOne {
    
    public static int solution(int n) {
        int res = 0;
        for (long k = 1; k <= n; k *= 10) {
            long r = n / k;
            long m = n % k;
            res += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(NumberOfDigitOne.solution(13));
    }

}
