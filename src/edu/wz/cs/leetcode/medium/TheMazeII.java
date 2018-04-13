package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 505. The Maze II<br>
 * https://leetcode.com/problems/the-maze-ii<br><br>
 * 
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left 
 * or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.<br>
 * 
 * Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the 
 * destination. The distance is defined by the number of empty spaces traveled by the ball from the start position 
 * (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.<br>
 * 
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the 
 * borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.<br><br>
 * 
 * Note:<br>
 * 1. There is only one ball and one destination in the maze.<br>
 * 2. Both the ball and the destination exist on an empty space, and they will not be at the same position initially.<br>
 * 3. The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the 
 * border of the maze are all walls.<br>
 * 4. The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 */
public class TheMazeII {
    
    public static int solution(int[][] maze, int[] start, int[] dest) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dists = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dists[i], Integer.MAX_VALUE);
        }
        
        int[][] dirs = { {0, -1}, {-1, 0}, {0, 1}, {1, 0} };
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        dists[start[0]][start[1]] = 0;
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            
            for (int[] dir : dirs) {
                int i = pos[0];
                int j = pos[1];
                int dist = dists[i][j];
                while (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] == 0) {
                    i += dir[0];
                    j += dir[1];
                    dist++;
                }
                
                // step back one position
                i -= dir[0];
                j -= dir[1];
                dist--;
                if (dists[i][j] > dist) {
                    dists[i][j] = dist;
                    if (i != dest[0] || j != dest[1]) {
                        queue.offer(new int[] {i, j});
                    }
                }
            }
        }
        
        int result = dists[dest[0]][dest[1]];
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    public static void main(String[] args) {
        int[][] maze = { {0, 0, 1, 0, 0},
                         {0, 0, 0, 0, 0},
                         {0, 0, 0, 1, 0},
                         {1, 1, 0, 1, 1},
                         {0, 0, 0, 0, 0} };
        int[] start = {0, 4};
        int[] dest = {4, 4};
        System.out.println(TheMazeII.solution(maze, start, dest));
        
        int[][] maze2 = { {0, 0, 1, 0, 0},
                          {0, 0, 0, 0, 0},
                          {0, 0, 0, 1, 0},
                          {1, 1, 0, 1, 1},
                          {0, 0, 0, 0, 0} };
        int[] start2 = {0, 4};
        int[] dest2 = {3, 2};
        System.out.println(TheMazeII.solution(maze2, start2, dest2));
    }

}
