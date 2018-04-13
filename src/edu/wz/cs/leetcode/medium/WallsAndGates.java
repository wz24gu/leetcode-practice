package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 286. Walls and Gates<br>
 * https://leetcode.com/problems/walls-and-gates<br><br>
 * 
 * You are given a m x n 2D grid initialized with these three possible values.<br>
 * -1 - A wall or an obstacle.<br>
 * 0 - A gate.<br>
 * 
 * INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that 
 * the distance to a gate is less than 2147483647.<br>
 * 
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 */
public class WallsAndGates {
    
    private static int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    
    public static void solution(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }   
    }
    
    private static void dfs(int[][] rooms, int i, int j, int dist) {
        rooms[i][j] = dist;
        
        int m = rooms.length;
        int n = rooms[0].length;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] > dist + 1) {
                dfs(rooms, x, y, dist + 1);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] rooms = new int[][] { {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                                      {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                                      {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                                      {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE} };
        WallsAndGates.solution(rooms);
        for (int i = 0; i < rooms.length; i++) {
            System.out.println(Arrays.toString(rooms[i]));
        }
    }

}
