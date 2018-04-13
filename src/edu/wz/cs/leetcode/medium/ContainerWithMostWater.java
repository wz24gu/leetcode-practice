package edu.wz.cs.leetcode.medium;

/**
 * 11. Container With Most Water<br>
 * https://leetcode.com/problems/container-with-most-water<br><br>
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines 
 * are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis 
 * forms a container, such that the container contains the most water.<br>
 * 
 * Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
    
    public static int solution(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int result = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            result = Math.max(result, area);
            if (height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] height = {2, 4, 7, 1, 7, 3};
        System.out.println(ContainerWithMostWater.solution(height));
    }

}
