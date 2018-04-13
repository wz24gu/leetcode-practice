package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. Brick Wall<br>
 * https://leetcode.com/problems/brick-wall<br><br>
 * 
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the 
 * same height but different width. You want to draw a vertical line from the top to the bottom and cross the least 
 * bricks.<br>
 * 
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick 
 * in this row from left to right.<br>
 * 
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how 
 * to draw the line to cross the least bricks and return the number of crossed bricks.<br>
 * 
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously 
 * cross no bricks.<br><br>
 * 
 * Note:<br>
 * 1. The width sum of bricks in different rows are the same and won't exceed INT_MAX.<br>
 * 2. The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number 
 * of bricks of the wall won't exceed 20,000.
 */
public class BrickWall {
    
    public static int solution(List<List<Integer>> wall) {        
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for (List<Integer> list : wall) {
            int size = list.size();
            int sum = 0;
            for (int i = 0; i < size - 1; i++) {  // skip the last brick
                sum += list.get(i);                
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                max = Math.max(max, map.get(sum));
            }
        }
        
        return wall.size() - max;        
    }
    
    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 2, 1})));
        wall.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{3, 1, 2})));
        wall.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 3, 2})));
        wall.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{2, 4})));
        wall.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{3, 1, 2})));
        wall.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 3, 1, 1})));
        System.out.println(BrickWall.solution(wall));
    }

}
