package edu.wz.cs.leetcode.easy;

/**
 * 367. Valid Perfect Square<br>
 * https://leetcode.com/problems/valid-perfect-square<br><br>
 * 
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.<br>
 * 
 * Note: Do not use any built-in library function such as sqrt.
 */
public class ValidPerfectSquare {    
    
    public static boolean solution(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
    
    public static boolean solutionAlt(int num) {
        long x = num / 2;
        long t = x * x;
        while (t > num) {
            x /= 2;
            t = x * x;
        }
        for (long i = x; i <= x * 2 + 1; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean solutionX(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }
    
    public static void main(String[] args) {
        System.out.println(ValidPerfectSquare.solution(16));
        System.out.println(ValidPerfectSquare.solution(14));
        System.out.println(ValidPerfectSquare.solution(808201));
        
        System.out.println(ValidPerfectSquare.solutionAlt(16));
        System.out.println(ValidPerfectSquare.solutionAlt(14));
        System.out.println(ValidPerfectSquare.solutionAlt(808201));
        
        System.out.println(ValidPerfectSquare.solutionX(16));
        System.out.println(ValidPerfectSquare.solutionX(14));
        System.out.println(ValidPerfectSquare.solutionX(808201));
    }

}
