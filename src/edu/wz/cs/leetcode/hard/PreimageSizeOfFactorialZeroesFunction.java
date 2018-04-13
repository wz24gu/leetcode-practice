package edu.wz.cs.leetcode.hard;

/**
 * 793. Preimage Size of Factorial Zeroes Function<br>
 * https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function<br><br>
 * 
 * Let f(x) be the number of zeroes at the end of x!. (Recall that x! = 1 * 2 * 3 * ... * x, and by convention, 0! = 1.)<br>
 * 
 * For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has 2 zeroes at 
 * the end. Given K, find how many non-negative integers x have the property that f(x) = K.<br><br>
 * 
 * Note: K will be an integer in the range [0, 10^9].
 */
public class PreimageSizeOfFactorialZeroesFunction {
    
    public static int solution(int K) {
        return findRange(K) - findRange(K-1);
    }
    
    public static int findRange(int k) {
        long lo = 0;
        long hi = Long.MAX_VALUE;
        
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (getZeroes(mid) > k) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        
        return (int) lo - 1;
    }
    
    public static long getZeroes(long n) {
        long count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(PreimageSizeOfFactorialZeroesFunction.solution(0));
        System.out.println(PreimageSizeOfFactorialZeroesFunction.solution(5));
    }

}
