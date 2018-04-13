package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 391. Perfect Rectangle<br>
 * https://leetcode.com/problems/perfect-rectangle<br><br>
 * 
 * Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.<br>
 * 
 * Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented 
 * as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).
 */
public class PerfectRectangle {
    
    public static boolean solution(int[][] rectangles) {
        Map<String, Integer> map = new HashMap<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int count = 0;
        int area = 0;
        
        for (int[] rect : rectangles) {
            minX = Math.min(minX, rect[0]);
            minY = Math.min(minY, rect[1]);
            maxX = Math.max(maxX, rect[2]);
            maxY = Math.max(maxY, rect[3]);
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            
            if (!valid(map, rect[0] + "_" + rect[1], 1)) {
                return false;
            }
            if (!valid(map, rect[0] + "_" + rect[3], 2)) {
                return false;
            }
            if (!valid(map, rect[2] + "_" + rect[3], 4)) {
                return false;
            }
            if (!valid(map, rect[2] + "_" + rect[1], 8)) {
                return false;
            }
        }
        
        for (int i : map.values()) {
            if (i != 15 && i != 12 && i != 10 && i != 9 && i != 6 && i != 5 && i != 3) {
                count++;
            }
        }
        return count == 4 && area == (maxX - minX) * (maxY - minY);
    }
    
    private static boolean valid(Map<String, Integer> map, String s, int type) {        
        int val = map.getOrDefault(s, 0);
        if ((val & type) == 1) {
            return false;
        }
        map.put(s, val | type);
        return true;
    }
    
    public static void main(String[] args) {
        int[][] rectangles = { {1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4} };
        System.out.println(PerfectRectangle.solution(rectangles));
        
        int[][] rectangles2 = { {1, 1, 2, 3}, {1, 3, 2, 4}, {3, 1, 4, 2}, {3, 2, 4, 4} };
        System.out.println(PerfectRectangle.solution(rectangles2));
        
        int[][] rectangles3 = { {1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {3, 2, 4, 4} };
        System.out.println(PerfectRectangle.solution(rectangles3));
        
        int[][] rectangles4 = { {1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {2, 2, 4, 4} };
        System.out.println(PerfectRectangle.solution(rectangles4));
    }

}
