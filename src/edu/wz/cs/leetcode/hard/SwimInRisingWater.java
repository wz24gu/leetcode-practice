package edu.wz.cs.leetcode.hard;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 778. Swim in Rising Water<br>
 * https://leetcode.com/problems/swim-in-rising-water<br><br>
 * 
 * On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).<br>
 * 
 * Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 
 * 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can 
 * swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.<br>
 * 
 * You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?<br><br>
 * 
 * Note:<br>
 * 1. 2 <= N <= 50.<br>
 * 2. grid[i][j] is a permutation of [0, ..., N * N - 1].
 */
public class SwimInRisingWater {
    
    private static final int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    
    public static int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {0, 0, grid[0][0]});
        visited[0][0] = true;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int max = curr[2];
            
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    int newMax = Math.max(max, grid[x][y]);
                    if (x == n - 1 && y == n - 1) {
                        return newMax;
                    }
                    pq.offer(new int[] {x, y, newMax});
                }
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        int[][] grid = { {0, 2}, {1, 3} };
        System.out.println(SwimInRisingWater.solution(grid));
        
        int[][] grid2 = { {0, 1, 2, 3, 4},
                          {24, 23, 22, 21, 5},
                          {12, 13, 14, 15, 16},
                          {11, 17, 18, 19, 20},
                          {10, 9, 8, 7, 6} };
        System.out.println(SwimInRisingWater.solution(grid2));
    }

}
