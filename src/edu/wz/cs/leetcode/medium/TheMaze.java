package edu.wz.cs.leetcode.medium;

/**
 * 490. The Maze<br>
 * https://leetcode.com/problems/the-maze<br><br>
 * 
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, 
 * left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next 
 * direction.<br>
 * 
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the 
 * destination.<br>
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
public class TheMaze {
    
    public static boolean solution(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] marked = new boolean[m][n];
        return hasPath(maze, start, destination, marked);
    }
    
    private static boolean hasPath(int[][] maze, int[] start, int[] dest, boolean[][] marked) {
        int x = start[0];
        int y = start[1];
        if (marked[x][y]) {
            return false;
        }
        
        marked[x][y] = true;
        if (x == dest[0] && y == dest[1]) {
            return true;
        }
        
        // roll left
        if (y > 0 && maze[x][y-1] != 1) {
            int i = y - 1;
            while (i > 0 && maze[x][i-1] != 1) {
                i--;
            }
            if (hasPath(maze, new int[] {x, i}, dest, marked)) {
                return true;
            }
        }
        // roll right
        if (y < maze[0].length - 1 && maze[x][y+1] != 1) {
            int i = y + 1;
            while (i < maze[0].length - 1 && maze[x][i+1] != 1) {
                i++;
            }
            if (hasPath(maze, new int[] {x, i}, dest, marked)) {
                return true;
            }
        }
        // roll up
        if (x > 0 && maze[x-1][y] != 1) {
            int i = x - 1;
            while (i > 1 && maze[i-1][y] != 1) {
                i--;
            }
            if (hasPath(maze, new int[] {i, y}, dest, marked)) {
                return true;
            }
        }
        // roll down
        if (x < maze.length - 1 && maze[x+1][y] != 1) {
            int i = x + 1;
            while (i < maze.length - 1 && maze[i+1][y] != -1) {
                i++;
            }
            if (hasPath(maze, new int[] {i, x}, dest, marked)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[][] maze = { {0, 0, 1, 0, 0},
                         {0, 0, 0, 0, 0},
                         {0, 0, 0, 1, 0},
                         {1, 1, 0, 1, 1},
                         {0, 0, 0, 0, 0} };
        System.out.println(TheMaze.solution(maze, new int[] {0, 4}, new int[] {4, 4}));
        System.out.println(TheMaze.solution(maze, new int[] {0, 4}, new int[] {3, 2}));
    }

}
