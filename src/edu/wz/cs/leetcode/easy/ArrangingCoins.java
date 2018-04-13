package edu.wz.cs.leetcode.easy;

/**
 * 441. Arranging Coins<br>
 * https://leetcode.com/problems/arranging-coins<br><br>
 * 
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k
 * coins.<br>
 * 
 * Given n, find the total number of full staircase rows that can be formed. n is a non-negative integer and fits 
 * within the range of a 32-bit signed integer.
 */
public class ArrangingCoins {
    
    public static int solution(int n) {
        if (n == 0) {
            return 0;
        }
        
        int k = 1;
        int rem = n - k;
        while (rem >= k + 1) {
            k++;
            rem -= k;
        }
        return k;
    }
    
    public static int solutionAlt(int n) {
        int count = 0;
        int i = 1;
        while (n - i >= 0) {
            n -= i;
            i++;
            count++;
        }
        return count;
    }
    
    public static int solutionAlt2(int n) {
        int i = 0;
        while (n >= i) {
            n -= i;
            i++;
        }
        return i - 1;
    }
    
    public static int solutionX(int n) {
        if (n == 0) {
            return 0;
        }
        
        long lo = 1;
        long hi = n;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * (mid + 1) / 2 <= n) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return (int) (lo - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(ArrangingCoins.solution(5));
        System.out.println(ArrangingCoins.solution(6));
        System.out.println(ArrangingCoins.solution(8));
        
        System.out.println(ArrangingCoins.solutionX(5));
        System.out.println(ArrangingCoins.solutionX(6));
        System.out.println(ArrangingCoins.solutionX(8));
        
        System.out.println(ArrangingCoins.solutionAlt(5));
        System.out.println(ArrangingCoins.solutionAlt(6));
        System.out.println(ArrangingCoins.solutionAlt(8));
        
        System.out.println(ArrangingCoins.solutionAlt2(5));
        System.out.println(ArrangingCoins.solutionAlt2(6));
        System.out.println(ArrangingCoins.solutionAlt2(8));
    }

}
