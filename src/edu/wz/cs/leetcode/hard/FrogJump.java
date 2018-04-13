package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 403. Frog Jump<br/>
 * https://leetcode.com/problems/frog-jump<br/><br/>
 * 
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. 
 * The frog can jump on a stone, but it must not jump into the water.<br/>
 * 
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the 
 * river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 
 * unit.<br/>
 * 
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog 
 * can only jump in the forward direction.<br/><br/>
 * 
 * Note:<br/>
 * 1. The number of stones is >= 2 and is < 1,100.<br/>
 * 2. Each stone's position will be a non-negative integer < 2^31.<br/>
 * 3. The first stone's position is always 0.
 */
public class FrogJump {
    
    public static boolean solution(int[] stones) {
        if (stones.length == 0) {
            return true;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        
        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = stone + step;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                
                Set<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) {
                        set.add(step - 1);
                    }
                    set.add(step + 1);
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(FrogJump.solution(stones));
        
        int[] stones2 = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(FrogJump.solution(stones2));
    }

}
