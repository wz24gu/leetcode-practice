package edu.wz.cs.leetcode.easy;

/**
 * 342. Power of Four<br>
 * https://leetcode.com/problems/power-of-four<br><br>
 * 
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.<br>
 * 
 * Example: Given num = 16, return true. Given num = 5, return false.<br>
 * 
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {
    
    public static boolean solution(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
    
    public static boolean solutionX(int n) {
        if (n <= 0) {
            return false;
        }
        // left side to check if it is power of 2
        return (n & (n - 1)) == 0 && (n & 0x55555555) == n;
    }
    
    public static void main(String[] args) {
        System.out.println(PowerOfFour.solution(16));
        System.out.println(PowerOfFour.solution(5));
        System.out.println(PowerOfFour.solutionX(16));
        System.out.println(PowerOfFour.solutionX(5));
    }

}
