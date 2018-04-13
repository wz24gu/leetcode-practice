package edu.wz.cs.leetcode.easy;

/**
 * 326. Power of Three<br>
 * https://leetcode.com/problems/power-of-three<br><br>
 * 
 * Given an integer, write a function to determine if it is a power of three.<br>
 * 
 * Follow up: Could you do it without using any loop / recursion?
 */
public class PowerOfThree {

    public static boolean solution(int n) {
        if (n <= 0) {
            return false;
        }
        
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }
    
    public static boolean solutionAlt(int n) {
        if (n <= 0) {
            return false;
        }
        
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
    
    public static boolean solutionX(int n) {
        if (n <= 0) {
            return false;
        }
        
        double a = Math.log10(n) / Math.log10(3);
        return (int) a - a == 0;
    }
    
    public static void main(String[] args) {
        System.out.println(PowerOfThree.solution(81));
        System.out.println(PowerOfThree.solutionAlt(81));
        System.out.println(PowerOfThree.solutionX(81));
    }

}
