package edu.wz.cs.leetcode.medium;

/**
 * 754. Reach a Number<br>
 * https://leetcode.com/problems/reach-a-number<br><br>
 * 
 * You are standing at position 0 on an infinite number line. There is a goal at position target.<br>
 * 
 * On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.<br>
 * 
 * Return the minimum number of steps required to reach the destination.<br>
 * 
 * Note: target will be a non-zero integer in the range [-10 ^ 9, 10 ^ 9].
 */
public class ReachANumber {
    
    public static int solution(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        
        return step;
    }
    
    public static void main(String[] args) {
        System.out.println(ReachANumber.solution(3));
        System.out.println(ReachANumber.solution(2));
    }

}
