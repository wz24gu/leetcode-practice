package edu.wz.cs.leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 317. Shortest Distance from All Buildings<br/>
 * https://leetcode.com/problems/shortest-distance-from-all-buildings<br/><br/>
 * 
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can 
 * only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:<br/>
 * 1. Each 0 marks an empty land which you can pass by freely.<br/>
 * 2. Each 1 marks a building which you cannot pass through.<br/>
 * 3. Each 2 marks an obstacle which you cannot pass through.<br/><br/>
 * 
 * Note: There will be at least one building. If it is not possible to build such house according to the above rules, 
 * return -1.
 */
public class ShortestDistanceFromAllBuildings {
    
    public static int solution(int[][] grid) {
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        
        int building = 0;
        int[][] dist = new int[m][n];
        int[][] count = new int[m][n];        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    building++;
                    
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});
                    
                    boolean[][] marked = new boolean[m][n];
                    int level = 1;
                    
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] point = queue.poll();
                            int x = point[0];
                            int y = point[1];
                            for (int[] dir : dirs) {
                                x += dir[0];
                                y += dir[1];
                                if (x >= 0 && x < m && y >= 0 && y < n
                                        && grid[x][y] == 0 && !marked[x][y]) {
                                    dist[x][y] += level;
                                    count[x][y]++;
                                    marked[x][y] = true;
                                    queue.offer(new int[] {x, y});
                                }
                            }                            
                        }
                        level++;
                    }
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && count[i][j] == building) {
                    result = Math.min(result, dist[i][j]);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    public static void main(String[] args) {
        int[][] grid = { {1, 0, 2, 0, 1},
                         {0, 0, 0, 0, 0},
                         {0, 0, 1, 0, 0} };
        System.out.println(ShortestDistanceFromAllBuildings.solution(grid));
    }

}
