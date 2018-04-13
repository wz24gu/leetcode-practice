package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 356. Line Reflection<br>
 * https://leetcode.com/problems/line-reflection<br><br>
 * 
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.<br>
 * 
 * Example 1: Given points = [[1,1],[-1,1]], return true.<br>
 * 
 * Example 2: Given points = [[1,1],[-1,-1]], return false.<br>
 * 
 * Follow up: Could you do better than O(n2)?
 */
public class LineReflection {
    
    public static boolean solution(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<>();  // may have duplicated x or y
        for (int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            if (!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<Integer>());
            }
            map.get(point[0]).add(point[1]);
        }
        
        double mid = (double) (max + min) / 2;
        for (int[] point : points) {
            int x = (int) (2 * mid - point[0]);
            if (!map.containsKey(x) || !map.get(x).contains(point[1])) {
                return false;
            }
        }
        
        return true;        
    }
    
    public static void main(String[] args) {
        int[][] points = { {1, 1}, {-1, 1} };
        System.out.println(LineReflection.solution(points));
        
        int[][] points2 = { {1, 1}, {-1, -1} };
        System.out.println(LineReflection.solution(points2));
    }

}
