package edu.wz.cs.leetcode.easy;

/**
 * 374. Guess Number Higher or Lower<br>
 * https://leetcode.com/problems/guess-number-higher-or-lower<br><br>
 * 
 * We are playing the Guess Game. The game is as follows:<br>
 * I pick a number from 1 to n. You have to guess which number I picked. Every time you guess wrong, I'll tell you 
 * whether the number is higher or lower.<br>
 * 
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):<br>
 * -1 : My number is lower<br>
 *  1 : My number is higher<br>
 *  0 : Congrats! You got it!
 */
public class GuessNumberHigherOrLower {
    
    private static int guess(int num) {
        return 0;
    }
    
    public static int solution(int n) {
        int lo = 1;
        int hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            int result = guess(mid);
            if (result == -1) {
                hi = mid - 1;
            }
            else if (result == 1) {
                lo = mid + 1;
            }
            else {
                return mid;
            }            
        }
        return -1;
    }

}
