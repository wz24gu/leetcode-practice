package edu.wz.cs.leetcode.easy;

/**
 * 479. Largest Palindrome Product<br>
 * https://leetcode.com/problems/largest-palindrome-product<br><br>
 * 
 * Find the largest palindrome made from the product of two n-digit numbers.<br>
 * 
 * Since the result could be very large, you should return the largest palindrome mod 1337.<br>
 * 
 * Example:<br>
 * Input: 2; Output: 987; Explanation: 99 x 91 = 9009, 9009 % 1337 = 987<br>
 * 
 * Note: The range of n is [1,8].
 */
public class LargestPalindromeProduct {
    
    public static int solution(int n) {
        if (n == 1) {
            return 9;
        }
        
        long max = (long) Math.pow(10, n) - 1;
        long min = (long) Math.pow(10, n - 1);
        long product = max * max;
        long firstHalf = product / (long) Math.pow(10, n);
        
        while (true) {
            long palindrome = buildPalindrome(firstHalf--);
            if (palindrome > product) {
                continue;
            }
            for (long i = max; i >= min; i--) {
                if (palindrome / i > max) {
                    break;
                }
                if (palindrome % i == 0) {
                    System.out.println(palindrome);
                    return (int) (palindrome % 1337);
                }
            }
        }        
    }
    
    private static long buildPalindrome(long firstHalf) {
        String str = firstHalf + new StringBuilder().append(firstHalf).reverse().toString();
        return Long.parseLong(str);
    }
    
    public static void main(String[] args) {
        System.out.println(LargestPalindromeProduct.solution(2));
    }

}
