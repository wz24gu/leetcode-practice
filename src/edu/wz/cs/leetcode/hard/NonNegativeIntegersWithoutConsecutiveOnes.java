package edu.wz.cs.leetcode.hard;

/**
 * 600. Non-negative Integers without Consecutive Ones<br>
 * https://leetcode.com/problems/non-negative-integers-without-consecutive-ones<br><br>
 * 
 * Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary 
 * representations do NOT contain consecutive ones.<br>
 * 
 * Note: 1 <= n <= 10 ^ 9
 */
public class NonNegativeIntegersWithoutConsecutiveOnes {
    
    public static int solution(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));
        int n = sb.length();
        
        int[] a = new int[n];  // end with 0
        int[] b = new int[n];  // end with 1
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }        
        int result = a[n-1] + b[n-1];
        
        for (int i = 1; i < n; i++) {
            if (sb.charAt(i) == '1' && sb.charAt(i - 1) == '1') {
                break;
            }
            if (sb.charAt(i) == '0' && sb.charAt(i - 1) == '0') {
                result -= b[n-i-1];
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(NonNegativeIntegersWithoutConsecutiveOnes.solution(5));
    }

}
