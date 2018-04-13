package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 488. Zuma Game<br/>
 * 
 * Think about Zuma Game. You have a row of balls on the tablee, colored red (R), yellow (Y), blue (B), green (G), and
 * while (W). You also have several balls in your hand.<br/>
 * Each time, you may choose a ball in your hand, and insert it in the row (including the leftmost place and the rightmost
 * place). Then, if there is a group of 3 or more balls in the same color touching, remove these balls. Keep doing this
 * until no more balls can be removed.<br/>
 * Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls,
 * output -1.<br/><br/>
 * 
 * Note:<br/>
 * 1. You may assume that the initial row of balls on the table won't have any 3 or more consecutive balls with the same
 * color.<br/>
 * 2. The number of balls on the table won't exceed 20, and the string represents these balls is called board in the input.<br/>
 * 3. The number of balls in your hand won't exceed 5, and the string represents these balls is balled hand in the input.<br/>
 * 4. Both input strings will be non-empty and only contain character 'R', 'Y', 'B', 'G', 'W'.
 */
public class ZumaGame {

    public static int solution(String board, String hand) {
        int result = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : hand.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        result = helper(board, map);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private static int helper(String board, Map<Character, Integer> map) {
        board = clearBoard(board);
        if (board.isEmpty()) {
            return 0;
        }
        
        int count = Integer.MAX_VALUE;
        int n = board.length();
        for (int i = 0, j = 0; j <= n; j++) {
            if (j < n && board.charAt(i) == board.charAt(j)) {
                continue;
            }
            
            int need = 3 - (j - i);  // j is the first element that is not i
            char c = board.charAt(i);
            if (map.get(c) != null && map.get(c) >= need) {
                map.put(c, map.get(c) - need);
                int t = helper(board.substring(0, i) + board.substring(j), map);
                if (t != Integer.MAX_VALUE) {
                    count = Math.min(count, t + need);
                }
                map.put(c, map.get(c) + need);  // reset balls in hand
            }            
            i = j;
        }
        
        return count;
    }
    
    private static String clearBoard(String board) {
        int n = board.length();
        for (int i = 0, j = 0; j <= n; j++) {
            if (j < n && board.charAt(i) == board.charAt(j)) {
                continue;
            }
            
            if (j - i >= 3) {  // j is the position of the first element that is not i                
                return clearBoard(board.substring(0, i) + board.substring(j));
            }
            else {
                i = j;
            }
        }
        return board;
    }
    
    public static void main(String[] args) {
        System.out.println(ZumaGame.solution("WRRBBW", "RB"));
        System.out.println(ZumaGame.solution("WWRRBBWW", "WRBRW"));
        System.out.println(ZumaGame.solution("G", "GGGGG"));
        System.out.println(ZumaGame.solution("RBYYBBRRB", "YRBGB"));
    }

}
