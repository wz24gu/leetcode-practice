package edu.wz.cs.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 733. Flood Fill<br>
 * https://leetcode.com/problems/flood-fill<br><br>
 * 
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 
 * to 65535).<br>
 * 
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value 
 * newColor, "flood fill" the image.<br>
 * 
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting 
 * pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with 
 * the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the 
 * newColor.<br>
 * 
 * At the end, return the modified image.<br><br>
 * 
 * Note:<br>
 * 1. The length of image and image[0] will be in the range [1, 50].<br>
 * 2. The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.<br>
 * 3. The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class FloodFill {
    
    public static int[][] solutionBFS(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        int color = image[sr][sc];
        
        int[][] dirs = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            image[pos[0]][pos[1]] = newColor;  // change the original image, otherwise the loop will be infinite
            
            for (int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                if (x < 0 || x >= row || y < 0 || y >= col || image[x][y] != color) {
                    continue;
                }
                queue.offer(new int[] {x, y});
            }            
        }
        
        return image;        
    }
    
    public static int[][] solutionDFS(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private static void helper(int[][] image, int i, int j, int color, int newColor) {
        int row = image.length;
        int col = image[0].length;
        
        if (i < 0 || i >= row || j < 0 || j >= col || image[i][j] != color) {
            return;
        }
        
        image[i][j] = newColor;
        helper(image, i + 1, j, color, newColor);
        helper(image, i - 1, j, color, newColor);
        helper(image, i, j + 1, color, newColor);
        helper(image, i, j - 1, color, newColor);
    }
    
    private static int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    
    public static int[][] solutionX(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color == newColor) {
            return image;
        }
        dfs(image, sr, sc, color, newColor);
        return image;
    }
    
    private static void dfs(int[][] image, int i, int j, int color, int newColor) {
        image[i][j] = newColor;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == color) {
                dfs(image, x, y, color, newColor);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] image = { {1, 1, 1}, {1, 1, 0}, {1, 0, 1} };
        int[][] result = FloodFill.solutionBFS(image, 1, 1, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        
        int[][] image2 = { {1, 1, 1}, {1, 1, 0}, {1, 0, 1} };
        int[][] result2 = FloodFill.solutionDFS(image2, 1, 1, 2);
        for (int i = 0; i < result2.length; i++) {
            System.out.println(Arrays.toString(result2[i]));
        }
        
        int[][] image3 = { {1, 1, 1}, {1, 1, 0}, {1, 0, 1} };
        int[][] result3 = FloodFill.solutionX(image3, 1, 1, 2);
        for (int i = 0; i < result3.length; i++) {
            System.out.println(Arrays.toString(result3[i]));
        }
    }

}
