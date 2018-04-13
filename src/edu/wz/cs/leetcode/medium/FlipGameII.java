package edu.wz.cs.leetcode.medium;

/**
 * 294. Flip Game II<br>
 * https://leetcode.com/problems/flip-game-ii<br><br>
 * 
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + 
 * and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no 
 * longer make a move and therefore the other person will be the winner.<br>
 * 
 * Write a function to determine if the starting player can guarantee a win.<br>
 * 
 * For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to 
 * become "+--+".<br>
 * 
 * Follow up: Derive your algorithm's runtime complexity.
 */
public class FlipGameII {
    
    /**
     * if we have n element, in the worst case, we need to flip n - 1
     * after we flip, we have in the worst case n - 2 - 1 flip
     * so the time complexity is (n - 1) * (n - 3) * (n - 5) ... O(n!)
     */
    public static boolean solution(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                String newS = s.substring(0, i - 1) + "--" + s.substring(i + 1);
                if (!solution(newS)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(FlipGameII.solution("++++"));
    }

}
