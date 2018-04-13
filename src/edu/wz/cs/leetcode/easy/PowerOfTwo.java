package edu.wz.cs.leetcode.easy;

/**
 * 231. Power of Two<br>
 * https://leetcode.com/problems/power-of-two<br><br>
 * 
 * Given an integer, write a function to determine if it is a power of two.<br>
 * 
 * Hint: Could you solve it in O(1) time and using O(1) space?
 */
public class PowerOfTwo {
    
    public static boolean solution(int n) {
        if (n <= 0) {
            return false;
        }
        
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count == 1;
    }
    
    public static boolean solutionAlt(int n) {
        if (n <= 0) {
            return false;
        }
        
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
    
    public static boolean solutionX(int n) {
        if (n <= 0) {
            return false;
        }
        
        return (n & (n - 1)) == 0;
    }
    
    public static void main(String[] args) {
        System.out.println(PowerOfTwo.solution(16));
        System.out.println(PowerOfTwo.solutionAlt(16));
        System.out.println(PowerOfTwo.solutionX(16));
    }

}
