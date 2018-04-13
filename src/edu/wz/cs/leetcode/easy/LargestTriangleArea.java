package edu.wz.cs.leetcode.easy;

/**
 * 812. Largest Triangle Area<br>
 * https://leetcode.com/problems/largest-triangle-area<br><br>
 * 
 * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the 
 * points.<br><br>
 * 
 * Notes:<br>
 * 1. 3 <= points.length <= 50.<br>
 * 2. No points will be duplicated.<br>
 * 3. -50 <= points[i][j] <= 50.<br>
 * 4. Answers within 10^-6 of the true value will be accepted as correct.
 */
public class LargestTriangleArea {
    
    public static double solution(int[][] points) {
        double res = 0;
        for (int[] a : points) {
            for (int[] b : points) {
                for (int[] c : points) {
                    double area = 0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[1] * b[0] - b[1] * c[0] - c[1] * a[0]);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] points = { {0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0} };
        System.out.println(LargestTriangleArea.solution(points));
    }

}
