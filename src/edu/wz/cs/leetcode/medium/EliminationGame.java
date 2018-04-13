package edu.wz.cs.leetcode.medium;

/**
 * 390. Elimination Game<br>
 * https://leetcode.com/problems/elimination-game<br><br>
 * 
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other 
 * number afterward until you reach the end of the list.<br>
 * 
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number 
 * from the remaining numbers.<br>
 * 
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.<br>
 * 
 * Find the last number that remains starting with a list of length n.
 */
public class EliminationGame {
    
    public static int solution(int n) {
        boolean left = true;
        int ren = n;
        int step = 1;
        int head = 1;
        
        while (ren > 1) {
            if (left || ren % 2 == 1) {
                head += step;
            }
            ren /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
    
    public static void main(String[] args) {
        System.out.println(EliminationGame.solution(9));
    }

}
