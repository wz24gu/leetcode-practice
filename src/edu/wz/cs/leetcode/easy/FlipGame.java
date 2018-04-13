package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 293. Flip Game<br>
 * https://leetcode.com/problems/flip-game<br><br>
 * 
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters:
 * + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner.<br>
 * 
 * Write a function to compute all possible states of the string after one valid move. If there is no valid move,
 * return an empty list [].
 */
public class FlipGame {
    
    public static List<String> solution(String s) {
        List<String> result = new ArrayList<>();        
        if (s == null || s.length() <= 1) {
            return result;
        }
        
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
                result.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
            }
        }
        return result;
    }
    
    public static List<String> solutionAlt(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 1) {
            return result;
        }
        
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '+' && arr[i-1] == '+') {
                arr[i] = '-';
                arr[i-1] = '-';
                result.add(new String(arr));
                arr[i] = '+';
                arr[i-1] = '+';
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(FlipGame.solution("++++"));
        System.out.println(FlipGame.solutionAlt("++++"));
    }

}
