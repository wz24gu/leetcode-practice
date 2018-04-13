package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. Rabbits in Forest<br>
 * https://leetcode.com/problems/rabbits-in-forest<br><br>
 * 
 * In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits 
 * have the same color as them. Those answers are placed in an array.<br>
 * 
 * Return the minimum number of rabbits that could be in the forest.<br><br>
 * 
 * Note:<br>
 * 1. answers will have length at most 1000.<br>
 * 2. Each answers[i] will be an integer in the range [0, 999].
 */
public class RabbitsInForest {
    
    public static int solution(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : answers) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        int res = 0;
        for (int a : map.keySet()) {
            int n = map.get(a);            
            int group = n % (a + 1) == 0 ? n / (a + 1) : n / (a + 1) + 1;
            res += group * (a + 1);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] answers = {1, 1, 2};
        System.out.println(RabbitsInForest.solution(answers));
        
        int[] answers2 = {10, 10, 10};
        System.out.println(RabbitsInForest.solution(answers2));
        
        int[] answers3 = {};
        System.out.println(RabbitsInForest.solution(answers3));
    }

}
