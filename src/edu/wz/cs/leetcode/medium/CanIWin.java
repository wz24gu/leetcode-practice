package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 464. Can I Win<br>
 * https://leetcode.com/problems/can-i-win<br><br>
 * 
 * In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first 
 * causes the running total to reach or exceed 100 wins.<br>
 * 
 * What if we change the game so that players cannot re-use integers?<br>
 * 
 * For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until 
 * they reach a total >= 100.<br>
 * 
 * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can 
 * force a win, assuming both players play optimally.<br>
 * 
 * You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
 */
public class CanIWin {
    
    public static boolean solution (int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        
        Map<Integer, Boolean> map = new HashMap<>();
        return helper(desiredTotal, maxChoosableInteger, 0, map);
    }
    
    private static boolean helper(int total, int n, int state, Map<Integer, Boolean> map) {
        if (map.containsKey(state)) {
            return map.get(state);
        }
        
        for (int i = 0; i < n; i++) {
            if ((state & (1 << i)) != 0) {  // integer already used
                continue;
            }
            
            if (total <= i + 1 || !helper(total - i - 1, n, state | (1 << i), map)) {
                map.put(state, true);
                return true;
            }            
        }
        
        map.put(state, false);
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(CanIWin.solution(10, 11));
    }

}
