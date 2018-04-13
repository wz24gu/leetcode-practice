package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 755. Pour Water<br>
 * https://leetcode.com/problems/pour-water<br><br>
 * 
 * We are given an elevation map, heights[i] representing the height of the terrain at that index. The width at each 
 * index is 1. After V units of water fall at index K, how much water is at each index?<br>
 * 
 * Water first drops at index K and rests on top of the highest terrain or water at that index. Then, it flows according to 
 * the following rules:<br>
 * 1. If the droplet would eventually fall by moving left, then move left.<br>
 * 2. Otherwise, if the droplet would eventually fall by moving right, then move right.<br>
 * 3. Otherwise, rise at it's current position.<br>
 * 
 * Here, "eventually fall" means that the droplet will eventually be at a lower level if it moves in that direction. 
 * Also, "level" means the height of the terrain plus any water in that column.<br>
 * 
 * We can assume there's infinitely high terrain on the two sides out of bounds of the array. Also, there could not be 
 * partial water being spread out evenly on more than 1 grid block - each unit of water has to be in exactly one block.<br><br>
 * 
 * Note:<br>
 * 1. heights will have length in [1, 100] and contain integers in [0, 99].<br>
 * 2. V will be in range [0, 2000].<br>
 * 3. K will be in range [0, heights.length - 1].
 */
public class PourWater {

    public static int[] solution(int[] heights, int V, int k) {
        for (int i = 0; i < V; i++) {
            int idx = getLeft(heights, k);
            if (idx != k) {
                heights[idx]++;
            }
            else {
                idx = getRight(heights, k);
                heights[idx]++;
            }
        }
        return heights;
    }
    
    private static int getLeft(int[] heights, int k) {
        int min = heights[k];
        int idx = k;
        for (int j = k - 1; j >= 0; j--) {
            if (heights[j] <= min) {
                if (heights[j] < min) {
                    idx = j;
                }
                min = heights[j];
            }
            else {
                break;
            }
        }
        return idx;
    }
    
    private static int getRight(int[] heights, int k) {
        int min = heights[k];
        int idx = k;
        for (int j = k + 1; j < heights.length; j++) {
            if (heights[j] <= min) {
                if (heights[j] < min) {
                    idx = j;
                }
                min = heights[j];
            }
            else {
                break;
            }
        }
        return idx;
    }
    
    public static void main(String[] args) {
        int[] heights = {2, 1, 1, 2, 1, 2, 2};
        System.out.println(Arrays.toString(PourWater.solution(heights, 4, 3)));
        
        int[] heights2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(PourWater.solution(heights2, 2, 2)));
        
        int[] heights3 = {3, 1, 3};
        System.out.println(Arrays.toString(PourWater.solution(heights3, 5, 1)));
    }
    
}
