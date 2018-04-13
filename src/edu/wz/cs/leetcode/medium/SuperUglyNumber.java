package edu.wz.cs.leetcode.medium;

/**
 * 313. Super Ugly Number<br>
 * https://leetcode.com/problems/super-ugly-number<br><br>
 * 
 * Write a program to find the nth super ugly number.<br>
 * 
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For 
 * example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes 
 * = [2, 7, 13, 19] of size 4.<br>
 * 
 * Note:<br><br>
 * (1) 1 is a super ugly number for any given primes.<br>
 * (2) The given numbers in primes are in ascending order.<br>
 * (3) 0 < k <= 100, 0 < n <= 106, 0 < primes[i] < 1000.<br>
 * (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
public class SuperUglyNumber {
    
    public static int solution(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
            }
            
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[idx[j]] <= ugly[i]) {
                    idx[j]++;
                }
            }
        }
        
        return ugly[n-1];
    }
    
    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        System.out.println(SuperUglyNumber.solution(12, primes));
    }

}
