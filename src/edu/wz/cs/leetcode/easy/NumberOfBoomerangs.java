package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. Number of Boomerangs<br>
 * https://leetcode.com/problems/number-of-boomerangs<br><br>
 * 
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that 
 * the distance between i and j equals the distance between i and k (the order of the tuple matters).<br>
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the 
 * range [-10000, 10000] (inclusive).
 */
public class NumberOfBoomerangs {
    
    public static int solution(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        
        int result = 0;
        
        int n = points.length;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {  // tricky, j should start with 0
                if (i == j) {
                    continue;
                }
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int dist = x * x  + y * y;
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            
            for (int num : map.values()) {
                result += num * (num - 1);  // Pn2
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[][] points = { {0, 0}, {1, 0}, {2, 0} };
        System.out.println(NumberOfBoomerangs.solution(points));
    }

}
