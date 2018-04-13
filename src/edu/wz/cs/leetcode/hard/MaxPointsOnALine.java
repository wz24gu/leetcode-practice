package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

import edu.wz.cs.leetcode.model.Point;

/**
 * 149. Max Points on a Line<br>
 * https://leetcode.com/problems/max-points-on-a-line<br><br>
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsOnALine {
    
    public static int solution(Point[] points) {
        int res = 0;
        int n = points.length;
        
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int dup = 1;
            for (int j = i + 1; j < n; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                }
                else if (points[i].x == points[j].x) {
                    map.put(Double.MAX_VALUE, map.getOrDefault(Double.MAX_VALUE, 0) + 1);
                }
                else {
                    double slope = (double) (points[j].y - points[i].y) / (double) (points[j].x - points[j].x);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }
            
            res = Math.max(res, dup);
            for (int num : map.values()) {
                res = Math.max(res, num + dup);
            }
        }
        
        return res;
    }
    
    // TODO: implement with gcd; cross product
    
    public static void main(String[] args) {
        Point[] points = new Point[3];
        points[0] = new Point(0, 0);
        points[1] = new Point(1, 1);
        points[2] = new Point(2, 2);
        System.out.println(MaxPointsOnALine.solution(points));
    }

}
