package edu.wz.cs.leetcode.hard;

import java.util.PriorityQueue;

/**
 * 407.  Trapping Rain Water II<br/>
 * 
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute 
 * the volume of water it is able to trap after raining.<br/><br/>
 * 
 * Note:<br/>
 * Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
 */
public class TrappingRainWaterII {
    
    private static class Cell {
        public int row;
        public int col;
        public int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    
    public static int solution(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }
        
        PriorityQueue<Cell> queue = new PriorityQueue<>(1, (a, b) -> a.height - b.height);
        
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] marked = new boolean[m][n];
        
        // first, add all Cells on borders to the queue
        for (int i = 0; i < m; i++) {
            queue.offer(new Cell(i, 0, heights[i][0]));
            marked[i][0] = true;
            queue.offer(new Cell(i, n - 1, heights[i][n-1]));
            marked[i][n-1] = true;
        }
        for (int i = 0; i < n; i++) {
            queue.offer(new Cell(0, i, heights[0][i]));
            marked[0][i] = true;
            queue.offer(new Cell(m - 1, i, heights[m-1][i]));
            marked[m-1][i] = true;
        }
        
        int[][] dirs = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        int result = 0;
        
        // pick the shortest cell in the queue and visit its neighbors
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !marked[row][col]) {
                    marked[row][col] = true;
                    result += Math.max(0, cell.height - heights[row][col]);
                    queue.offer(new Cell(row, col, Math.max(heights[row][col], cell.height)));
                }                
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[][] heights = { {1, 4, 3, 1, 3, 2},
                            {3, 2, 1, 3, 2, 4},
                            {2, 3, 3, 2, 3, 1} };
        System.out.println(TrappingRainWaterII.solution(heights));
    }

}
