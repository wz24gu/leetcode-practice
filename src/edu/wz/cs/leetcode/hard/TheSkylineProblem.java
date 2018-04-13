package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 218. The Skyline Problem<br>
 * https://leetcode.com/problems/the-skyline-problem<br><br>
 * 
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a 
 * distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo 
 * (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).<br>
 * 
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are 
 * the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed 
 * that 0 <= Li, Ri <= INT_MAX, 0 < Hi <= INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles 
 * grounded on an absolutely flat surface at height 0.<br>
 * 
 * For instance, the dimensions of all buildings in Figure A are recorded as: 
 * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .<br>
 * 
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] t
 * hat uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key 
 * point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero 
 * height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.<br>
 * 
 * For instance, the skyline in Figure B should be represented as:
 * [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].<br><br>
 * 
 * Notes:<br>
 * 1. The number of buildings in any input list is guaranteed to be in the range [0, 10000].<br>
 * 2. The input list is already sorted in ascending order by the left x position Li.<br>
 * 3. The output list must be sorted by the x position.<br>
 * 4. There must be no consecutive horizontal lines of equal height in the output skyline. For instance, 
 * [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one 
 * in the final output as such: [...[2 3], [4 5], [12 7], ...]
 */
public class TheSkylineProblem {
    
    public static List<int[]> solution(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return result;
        }
        
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[] {b[0], -b[2]});
            height.add(new int[] {b[1], b[2]});
        }
        
        Collections.sort(height, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int prev = 0;
        
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            }
            else {
                pq.remove(h[1]);
            }
            
            int curr = pq.peek();
            if (curr != prev) {
                result.add(new int[] {h[0], curr});
            }
            prev = curr;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[][] buildings = { {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
        List<int[]> result = TheSkylineProblem.solution(buildings);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(Arrays.toString(result.get(i)));
        }
    }

}
