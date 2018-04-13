package edu.wz.cs.leetcode.medium;

/**
 * 357. Count Numbers with Unique Digits<br>
 * https://leetcode.com/problems/count-numbers-with-unique-digits<br><br>
 * 
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 <= x < 10^n.<br>
 * 
 * Example: Given n = 2, return 91. (The answer should be the total numbers in the range of 0 <= x < 100, excluding 
 * [11,22,33,44,55,66,77,88,99])<br><br>
 * 
 * Hint:<br>
 * 1. A direct way is to use the backtracking approach.<br>
 * 2. Backtracking should contains three states which are (the current number, number of steps to get that number and a 
 * bitmask which represent which number is marked as visited so far in the current number). Start with state (0,0,0) 
 * and count all valid number till we reach number of steps equals to 10^n.<br>
 * 3. This problem can also be solved using a dynamic programming approach and some knowledge of combinatorics.<br>
 * 4. Let f(k) = count of numbers with unique digits with length equals k.
 * 5. f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number cannot start with 0].
 */
public class CountNumbersWithUniqueDigits {
    // f(1) = 10; f(k) = 9 * 9 * 8 * ... * (9 - k + 2)
    public static int solution(int n) {
        if (n == 0) {
            return 1;
        }
        
        n = Math.min(n, 10);
        int result = 10;
        int count = 9;
        
        for (int i = 2; i <= n; i++) {
            count *= (11 - i);
            result += count;
        }
        return result;
    }
    
    public static int solutionBT(int n) {
        if (n > 10) {
            n = 10;
        }
        
        int count = 1;  // n = 0
        long max = (long) Math.pow(10, n);
        boolean[] used = new boolean[10];
        for (int i = 1; i < 10; i++) {
            used[i]= true;
            count += search(i, max, used);
            used[i] = false;
        }
        return count;
    }
    
    public static int search(long prev, long max, boolean[] used) {
        int count = 0;
        if (prev < max) {
            count += 1;
        }
        else {
            return count;
        }
        
        for (int i = 0; i < 10; i++) {
            if (!used[i]) {
                used[i] = true;
                long current = prev * 10 + i;
                count += search(current, max, used);
                used[i] = false;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(CountNumbersWithUniqueDigits.solution(2));
        System.out.println(CountNumbersWithUniqueDigits.solution(3));
        
        System.out.println(CountNumbersWithUniqueDigits.solutionBT(2));
        System.out.println(CountNumbersWithUniqueDigits.solutionBT(3));
    }

}
