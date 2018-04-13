package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. Minimum Number of Arrows to Burst Balloons<br>
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons<br><br>
 * 
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the 
 * start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence 
 * the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 
 * 10 ^ 4 balloons.<br>
 * 
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend 
 * bursts by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. An 
 * arrow once shot keeps traveling up infinitely. The problem is to find the minimum number of arrows that must be shot 
 * to burst all balloons.
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    
    public static int solution(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        
        // sort by the first element and then second element
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        
        int n = points.length;
        int count = 1;
        int end = points[0][1];
        
        for (int i = 1; i < n; i++) {
            if (points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
            }
            else {
                count++;
                end = points[i][1];
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[][] points = { {10, 16}, {2, 8},  {1, 6},  {7, 12} };
        System.out.println(MinimumNumberOfArrowsToBurstBalloons.solution(points));
    }

}
