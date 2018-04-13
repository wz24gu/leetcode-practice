package edu.wz.cs.leetcode.easy;

/**
 * 9. Palindrome Number<br>
 * https://leetcode.com/problems/palindrome-number<br><br>
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    
    public static boolean solution(int n) {
        if (n < 0) {
            return false;
        }
        
        int div = 1;
        while (n / div >= 10) {
            div *= 10;
        }
        
        while (n > 0) {
            int left = n / div;
            int right = n % 10;
            if (left != right) {
                return false;
            }
            
            n = (n % div) / 10;
            div /= 100;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(PalindromeNumber.solution(1221));
        System.out.println(PalindromeNumber.solution(1000021));
        System.out.println(PalindromeNumber.solution(121));
    }

}
