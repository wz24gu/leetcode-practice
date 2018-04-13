package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow<br>
 * https://leetcode.com/problems/pacific-atlantic-water-flow<br><br>
 * 
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific 
 * ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.<br>
 * 
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.<br>
 * 
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.<br><br>
 * 
 * Note:<br>
 * 1. The order of returned grid coordinates does not matter.<br>
 * 2. Both m and n are less than 150.
 */
public class PacificAtlanticWaterFlow {
    
    private static int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    
    public static List<int[]> solution(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);  // left column
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1); // right column
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);  // top row
            dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, i);  // bottom row
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[] {i, j});
                }
            }
        }
        return result;
    }
    
    private static void dfs(int[][] matrix, boolean[][] marked, int height, int x, int y) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || marked[x][y] || matrix[x][y] < height) {
            return;
        }
        
        marked[x][y] = true;
        for (int[] dir : dirs) {
            dfs(matrix, marked, matrix[x][y], x + dir[0], y + dir[1]);
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 2, 3, 5},
                           {3, 2, 3, 4, 4},
                           {2, 4, 5, 3, 1},
                           {6, 7, 1, 4, 5},
                           {5, 1, 1, 2, 4} };
        List<int[]> result = PacificAtlanticWaterFlow.solution(matrix);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

}
