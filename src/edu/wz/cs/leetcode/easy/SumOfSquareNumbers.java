package edu.wz.cs.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 633. Sum of Square Numbers<br>
 * https://leetcode.com/problems/sum-of-square-numbers<br><br>
 * 
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 */
public class SumOfSquareNumbers {
    
    public static boolean solution(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 0; i <= sqrt; i++) {
            int m = n - i * i;
            int r = (int) Math.sqrt(m);
            if (r * r == m) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean solutionAlt(int n) {
        Set<Integer> set = new HashSet<>();        
        int sqrt = (int) Math.sqrt(n);
        for (int i = 0; i <= sqrt; i++) {
            set.add(i * i);
            if (set.contains(n - i * i)) {
                return true;
            }
        }
        return false;        
    }
    
    public static boolean solutionX(int n) {
        int a = 0;
        int b = (int) Math.sqrt(n);
        while (a <= b) {
            int c = a * a + b * b;
            if (c == n) {
                return true;
            }
            else if (c < n) {
                a++;
            }
            else {
                b--;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(SumOfSquareNumbers.solution(5));
        System.out.println(SumOfSquareNumbers.solutionAlt(5));
        System.out.println(SumOfSquareNumbers.solutionX(5));
        
        System.out.println(SumOfSquareNumbers.solution(3));
        System.out.println(SumOfSquareNumbers.solutionAlt(3));
        System.out.println(SumOfSquareNumbers.solutionX(3));
    }

}
