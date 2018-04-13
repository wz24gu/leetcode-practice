package edu.wz.cs.leetcode.hard;

/**
 * 42. Trapping Rain Water<br>
 * https://leetcode.com/problems/trapping-rain-water<br><br>
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water 
 * it is able to trap after raining.<br>
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {
    
    public static int solution(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            if (height[left] == min) {
                left++;
                while (left < right && height[left] < min) {
                    res += min - height[left];
                    left++;
                }
            }
            else {
                right--;
                while (left < right && height[right] < min) {
                    res += min - height[right];
                    right--;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(TrappingRainWater.solution(height));
    }

}
