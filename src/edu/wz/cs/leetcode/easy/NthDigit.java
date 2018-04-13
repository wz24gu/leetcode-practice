package edu.wz.cs.leetcode.easy;

/**
 * 400. Nth Digit<br>
 * https://leetcode.com/problems/nth-digit<br><br>
 * 
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...<br>
 * 
 * Note: n is positive and will fit within the range of a 32-bit signed integer (n < 2 ^ 31).
 */
public class NthDigit {
    
    public static int solution(int n) {
        // use long due to overflow
        long i = 1;
        long r = 9;
        long start = 1;
        while (n > r * i) {
            n -= r * i;
            i++;
            r *= 10;
            start *= 10;
        }
        
        start += (n - 1) / i;
        String result = String.valueOf(start);
        return result.charAt((int) ((n - 1) % i)) - '0';
    }
    
    public static void main(String[] args) {
        System.out.println(NthDigit.solution(3));
        System.out.println(NthDigit.solution(11));
    }

}
