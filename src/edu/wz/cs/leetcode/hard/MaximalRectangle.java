package edu.wz.cs.leetcode.hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * 85. Maximal Rectangle<br>
 * https://leetcode.com/problems/maximal-rectangle<br><br>
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 */
public class MaximalRectangle {

    public static int solution(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[cols + 1];
        height[0] = 0;
        int max = 0;
        
        for (int i = 0; i < rows; i++) {
            Stack<Integer> stack = new Stack<>();
            
            for (int j = 0; j < cols + 1; j++) {
                if (j < cols) {
                    if (matrix[i][j] == '1') {
                        height[j]++;
                    }
                    else {
                        height[j] = 0;
                    }
                }
                
                if (stack.isEmpty() || height[stack.peek()] <= height[j]) {
                    stack.push(j);
                }
                else {
                    while (!stack.isEmpty() && height[j] < height[stack.peek()]) {
                        int h = height[stack.pop()];
                        int w = stack.isEmpty() ? j : j - stack.peek() - 1;
                        max = Math.max(max, h * w);
                    }
                    stack.push(j);
                }
            }
        }
        
        return max;
    }
    
    public static int solutionDP(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        
        Arrays.fill(right, n);
        int max = 0;
        
        for (int i = 0; i < m; i++) {
            int curr_left = 0;
            int curr_right = n;
            
            // compute height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                }
                else {
                    height[j] = 0;
                }
            }
            
            // compute left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curr_left);
                }
                else {
                    left[j] = 0;
                    curr_left = j + 1;
                }
            }
            
            // compute right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curr_right);
                }
                else {
                    right[j] = n;
                    curr_right = j;
                }
            }
            
            // compute area
            for (int j = 0; j < n; j++) {
                max = Math.max(max, (right[j] - left[j]) * height[j]);
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        char[][] matrix = { {'1', '0', '1', '0', '0'},
                            {'1', '0', '1', '1', '1'},
                            {'1', '1', '1', '1', '1'},
                            {'1', '0', '0', '1', '0'} };
        System.out.println(MaximalRectangle.solution(matrix));
        System.out.println(MaximalRectangle.solutionDP(matrix));
    }

}
