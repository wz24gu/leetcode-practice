package edu.wz.cs.leetcode.easy;

/**
 * 788. Rotated Digits<br>
 * https://leetcode.com/problems/rotated-digits<br><br>
 * 
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different 
 * from X.  Each digit must be rotated - we cannot choose to leave it alone.<br>
 * 
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to 
 * each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become 
 * invalid.<br>
 * 
 * Now given a positive number N, how many numbers X from 1 to N are good?<br>
 * 
 * Note: N will be in range [1, 10000].
 */
public class RotatedDigits {
    
    public static int solution(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (valid(i)) {
                count++;
            }
        }
        return count;
    }
    
    private static boolean valid(int num) {
        boolean valid = false;
        while (num != 0) {
            int r = num % 10;
            if (r == 2 || r == 5 || r == 6 || r == 9) {
                valid = true;
            }
            else if (r == 3 || r == 4 || r == 7) {
                return false;
            }
            num /= 10;
        }
        return valid;
    }
    
    public static void main(String[] args) {
        System.out.println(RotatedDigits.solution(10));
    }

}
