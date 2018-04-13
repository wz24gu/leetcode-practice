package edu.wz.cs.leetcode.easy;

/**
 * 69. Sqrt(x)<br>
 * https://leetcode.com/problems/sqrtx<br>
 * 
 * Implement int sqrt(int x).<br>
 * 
 * Compute and return the square root of x, x is guaranteed to be a non-negative integer.
 */
public class SqaureRoot {
    
    public static int solution(int x) {
        long lo = 0;
        long hi = x / 2 + 1;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long square = mid * mid;
            if (square < x) {
                lo = mid + 1;
            }
            else if (square > x) {
                hi = mid - 1;
            }
            else {
                return (int) mid;
            }
        }
        
        return (int) hi;
    }
    
    public static int solutionAlt(int x) {
        if (x <= 1) {
            return x;
        }
        
        long r = x / 2;
        while (r * r > x) {
            r /= 2;
        }
        
        long i;
        for (i = 2 * r; i >= r; i--) {
            if (i * i <= x) {
                break;
            }
        }
        return (int) i;
    }
    
    // Newton's method
    public static int solutionX(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
    
    public static void main(String[] args) {
        System.out.println(SqaureRoot.solution(0));
        System.out.println(SqaureRoot.solution(1));
        System.out.println(SqaureRoot.solution(2));
        System.out.println(SqaureRoot.solution(3));
        System.out.println(SqaureRoot.solution(4));
        
        System.out.println(SqaureRoot.solutionAlt(0));
        System.out.println(SqaureRoot.solutionAlt(1));
        System.out.println(SqaureRoot.solutionAlt(2));
        System.out.println(SqaureRoot.solutionAlt(3));
        System.out.println(SqaureRoot.solutionAlt(4));
        
        System.out.println(SqaureRoot.solutionX(0));
        System.out.println(SqaureRoot.solutionX(1));
        System.out.println(SqaureRoot.solutionX(2));
        System.out.println(SqaureRoot.solutionX(3));
        System.out.println(SqaureRoot.solutionX(4));
    }

}
