package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 204. Count Primes<br>
 * https://leetcode.com/problems/count-primes<br><br>
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
    
    // Sieve of Eratosthenes
    public static int solution(int n) {
        if (n <= 1) {
            return 0;
        }
        
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            for (int j = i * i; j < n; j += i) {
                prime[j] = false;
            }
        }
        
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (prime[i]) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(CountPrimes.solution(120));
    }

}
