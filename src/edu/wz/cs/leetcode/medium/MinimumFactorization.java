package edu.wz.cs.leetcode.medium;

/**
 * 625. Minimum Factorization<br>
 * https://leetcode.com/problems/minimum-factorization<br><br>
 * 
 * Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.<br>
 * 
 * If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.
 */
public class MinimumFactorization {
    
    public static int solution(int a) {
        if (a < 10) {
            return a + 10;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                sb.insert(0, i);
                a /= i;
            }
        }
        
        if (a > 1) {  // cannot be divided
            return 0;
        }
        
        long result = Long.parseLong(sb.toString());
        return result > Integer.MAX_VALUE ? 0 : (int) result;
    }
    
    public static void main(String[] args) {
        System.out.println(MinimumFactorization.solution(48));
        System.out.println(MinimumFactorization.solution(15));
    }

}
