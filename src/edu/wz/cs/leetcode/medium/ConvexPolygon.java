package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 469. Convex Polygon<br>
 * https://leetcode.com/problems/convex-polygon<br><br>
 * 
 * Given a list of points that form a polygon when joined sequentially, find if this polygon is convex (Convex polygon 
 * definition).<br><br>
 * 
 * Note:<br>
 * 1. There are at least 3 and at most 10,000 points.<br>
 * 2. Coordinates are in the range -10,000 to 10,000.<br>
 * 3. You may assume the polygon formed by given points is always a simple polygon (Simple polygon definition). In other 
 * words, we ensure that exactly two edges intersect at each vertex, and that edges otherwise don't intersect each other.
 */
public class ConvexPolygon {
    
    public static boolean solution(List<List<Integer>> points) {
        boolean negative = false;
        boolean positive = false;
        
        int n = points.size();
        for (int A = 0; A < n; A++) {
            int B = (A + 1) % n;
            int C = (B + 1) % n;
            
            int crossProduct = crossProduct(
                points.get(A).get(0), points.get(A).get(1),
                points.get(B).get(0), points.get(B).get(1),
                points.get(C).get(0), points.get(C).get(1)
            );
            
            if (crossProduct < 0) {
                negative = true;
            }
            else if (crossProduct > 0) {
                positive = true;
            }
            
            if (negative && positive) {
                return false;
            }
        }
        
        return true;
    }
    
    private static int crossProduct(int Ax, int Ay, int Bx, int By, int Cx, int Cy) {
        int BAx = Ax - Bx;
        int BAy = Ay - By;
        int BCx = Cx - Bx;
        int BCy = Cy - By;
        return (BAx * BCy - BAy * BCx);
    }

    public static void main(String[] args) {
        List<List<Integer>> points = new ArrayList<>();
        points.add(Arrays.asList(0, 0));
        points.add(Arrays.asList(0, 1));
        points.add(Arrays.asList(1, 1));
        points.add(Arrays.asList(1, 0));
        System.out.println(ConvexPolygon.solution(points));
        
        List<List<Integer>> points2 = new ArrayList<>();
        points2.add(Arrays.asList(0, 0));
        points2.add(Arrays.asList(0, 10));
        points2.add(Arrays.asList(10, 10));
        points2.add(Arrays.asList(10, 0));
        points2.add(Arrays.asList(5, 5));
        System.out.println(ConvexPolygon.solution(points2));
        
    }
    
}
