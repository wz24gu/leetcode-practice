package edu.wz.cs.leetcode.easy;

import java.util.Stack;

/**
 * 682. Baseball Game<br>
 * https://leetcode.com/problems/baseball-game<br><br>
 * 
 * You're now a baseball game point recorder. Given a list of strings, each string can be one of the 4 following types:<br>
 * 1. Integer (one round's score): Directly represents the number of points you get in this round.<br>
 * 2. "+" (one round's score): Represents that the points you get in this round are the sum of the last two validround's points.<br>
 * 3. "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.<br>
 * 4. "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.<br>
 * 
 * Each round's operation is permanent and could have an impact on the round before and the round after. You need to
 * return the sum of the points you could get in all the rounds.<br>
 * 
 * Note:<br>
 * 1. The size of the input list will be between 1 and 1000.<br>
 * 2. Every integer represented in the list will be between -30000 and 30000.
 */
public class BaseballGame {
    
    public static int solution(String[] ops) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (String op : ops) {
            if (op.equals("+")) {
                int pre = stack.pop();
                int cur = pre + stack.peek();
                sum += cur;
                stack.push(pre);
                stack.push(cur);
            }
            else if (op.equals("D")) {
                int cur = stack.peek() * 2;
                sum += cur;
                stack.push(cur);
            }
            else if (op.equals("C")) {                
                sum -= stack.pop();
            }
            else {
                int cur = Integer.parseInt(op);
                sum += cur;
                stack.push(cur);
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        String[] points = {"5", "2", "C", "D", "+"};
        System.out.println(BaseballGame.solution(points));
        String[] points2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(BaseballGame.solution(points2));
    }

}
