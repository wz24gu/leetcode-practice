package edu.wz.cs.leetcode.easy;

/**
 * 397. Integer Replacement<br/>
 * https://leetcode.com/problems/integer-replacement<br/><br/>
 * 
 * Given a positive integer n and you can do operations as follow:<br/>
 * 1. If n is even, replace n with n/2.<br/>
 * 2. If n is odd, you can replace n with either n + 1 or n - 1.<br/>
 * 
 * What is the minimum number of replacements needed for n to become 1?
 */
public class IntegerReplacement {
    
    public static int solution(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + solution(n / 2);
        }
        return 1 + Math.min(solution(n + 1), solution(n - 1));
    }
    
    public static void main(String[] args) {
        System.out.println(IntegerReplacement.solution(8));
        System.out.println(IntegerReplacement.solution(7));
    }

}
