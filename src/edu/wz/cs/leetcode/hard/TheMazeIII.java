package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 499. The Maze III<br/>
 * 
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up (u), down 
 * (d), left (l) or right (r), but it won't stop rolling until hitting a wall. When the ball stops, it could choose the 
 * next direction. There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.<br/>
 * 
 * Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving 
 * the shortest distance. The distance is defined by the number of empty spaces traveled by the ball from the start 
 * position (excluded) to the hole (included). Output the moving directions by using 'u', 'd', 'l' and 'r'. Since there 
 * could be several different shortest ways, you should output the lexicographically smallest way. If the ball cannot 
 * reach the hole, output "impossible".<br/>
 * 
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the 
 * borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.<br/><br/>
 * 
 * Note:<br/>
 * 1. There is only one ball and one hole in the maze.<br/>
 * 2. Both the ball and hole exist on an empty space, and they will not be at the same position initially.<br/>
 * 3. The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the 
 * border of the maze are all walls.<br/>
 * 4. The maze contains at least 2 empty spaces, and the width and the height of the maze won't exceed 30.
 */
public class TheMazeIII {
    
    private int min;
    private String result;
    private int[][] maze;
    private int[] hole;
    private int[][] dist;
    private int[][] dirs = { {0, 1}, {-1, 0}, {1, 0}, {0, -1} };  // r, u, d, l
    
    public String solution(int[][] maze, int[] ball, int[] hole) {
        min = Integer.MAX_VALUE;
        result = null;
        this.maze = maze;
        this.hole = hole;

        dist = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        move(ball[0], ball[1], 0, "", -1);
        return result == null ? "impossible" : result;
    }
    
    private void move(int row, int col, int count, String path, int dir) {
        if (count > min || count > dist[row][col]) {  // not a shortest path
            return;
        }
        
        if (dir != -1) {  // not from start
            if (dir == 0) {
                path += 'r';
            }
            else if (dir == 1) {
                path += 'u';
            }
            else if (dir == 2) {
                path += 'd';
            }
            else {
                path += 'l';
            }
            
            while (row >= 0 && row < maze.length
                    && col >= 0 && col < maze[0].length
                    && maze[row][col] == 0) {
                dist[row][col] = Math.min(dist[row][col], count);
                
                // check for hole
                if (row == hole[0] && col == hole[1]) {
                    if (count == min && path.compareTo(result) < 0) {
                        result = path;
                    }
                    else if (count < min) {
                        min = count;
                        result = path;
                    }
                    return;
                }
                
                // keep rolling
                row += dirs[dir][0];
                col += dirs[dir][1];
                count++;
            }
            
            // hit the wall, roll back
            row -= dirs[dir][0];
            col -= dirs[dir][1];
            count--;
        }
        
        // start or hit the wall, try turning
        for (int i = 0; i < dirs.length; i++) {
            if (dir == i || dir == 3 - i) {  // don't keep going or going back
                continue;
            }
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];
            if (newRow >= 0 && newRow < maze.length
                    && newCol >= 0 && newCol < maze[0].length
                    && maze[newRow][newCol] == 0) {
                move(newRow, newCol, count, path, i);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] maze = { {0, 0, 0, 0, 0},
                         {1, 1, 0, 0, 1},
                         {0, 0, 0, 0, 0},
                         {0, 1, 0, 0, 1},
                         {0, 1, 0, 0, 0} };
        TheMazeIII mazeIII = new TheMazeIII();
        System.out.println(mazeIII.solution(maze, new int[] {4, 3}, new int[] {0, 1}));
        
        int[][] maze2 = { {0, 0, 0, 0, 0},
                          {1, 1, 0, 0, 1},
                          {0, 0, 0, 0, 0},
                          {0, 1, 0, 0, 1},
                          {0, 1, 0, 0, 0} };
        TheMazeIII mazeIII2 = new TheMazeIII();
        System.out.println(mazeIII2.solution(maze2, new int[] {4, 3}, new int[] {3, 0}));
    }

}
