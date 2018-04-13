package edu.wz.cs.leetcode.hard;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram<br>
 * https://leetcode.com/problems/largest-rectangle-in-histogram<br><br>
 * 
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area 
 * of largest rectangle in the histogram.<br>
 * 
 * For example, Given heights = [2, 1, 5, 6, 2, 3], return 10.
 */
public class LargestRectangleInHistogram {
    
    public static int solution(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int result = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && heights[i] <= heights[i+1]) {
                continue;
            }
            
            int minH = heights[i];
            for (int j = i; j >= 0; j--) {
                minH = Math.min(minH, heights[j]);
                int area = minH * (i - j + 1);
                result = Math.max(result, area);
            }
        }
        
        return result;
    }
    
    public static int solutionX(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int result = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            }
            else {
                int idx = stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = heights[idx] * w;
                result = Math.max(result, area);
                i--;
            }
        }
        
        return result;        
    }
    
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(LargestRectangleInHistogram.solution(heights));
        System.out.println(LargestRectangleInHistogram.solutionX(heights));
    }

}
