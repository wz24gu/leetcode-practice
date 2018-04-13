package edu.wz.cs.leetcode.easy;

/**
 * 172. Factorial Trailing Zeroes<br>
 * https://leetcode.com/problems/factorial-trailing-zeroes<br><br>
 * 
 * Given an integer n, return the number of trailing zeroes in n!.<br>
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {
    
    public static int solution(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(FactorialTrailingZeroes.solution(0));
        System.out.println(FactorialTrailingZeroes.solution(6));
        System.out.println(FactorialTrailingZeroes.solution(25));
        System.out.println(FactorialTrailingZeroes.solution(2147483647));
    }

}
