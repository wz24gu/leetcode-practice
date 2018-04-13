package edu.wz.cs.leetcode.easy;

/**
 * 657. Judge Route Circle<br/>
 * 
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle,
 * which means it moves back to the original place. The move sequence is represented by a string. And each move is
 * represent by a character. The valid robot moves are R (Right), L(Left), U (Up) and D (down). The output should be
 * true or false representing whether the robot makes a circle.
 */
public class JudgeRouteCircle {
    
    public static boolean solution(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        
        int horizontal = 0;
        int vertical = 0;
        int n = moves.length();
        for (int i = 0; i < n; i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                vertical++;
            }
            else if (c == 'D') {
                vertical--;
            }
            else if (c == 'R') {
                horizontal++;
            }
            else if (c == 'L') {
                horizontal--;
            }
            else {
                // ignore invalid input
            }
        }
        return horizontal == 0 && vertical == 0;
    }
    
    public static void main(String[] args) {
        System.out.println(JudgeRouteCircle.solution("UD"));
        System.out.println(JudgeRouteCircle.solution("LL"));
    }

}
