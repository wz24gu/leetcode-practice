package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 749. Contain Virus<br>
 * https://leetcode.com/problems/contain-virus<br><br>
 * 
 * A virus is spreading rapidly, and your task is to quarantine the infected area by installing walls.<br>
 * 
 * The world is modeled as a 2-D array of cells, where 0 represents uninfected cells, and 1 represents cells contaminated 
 * with the virus. A wall (and only one wall) can be installed between any two 4-directionally adjacent cells, on the 
 * shared boundary.<br>
 * 
 * Every night, the virus spreads to all neighboring cells in all four directions unless blocked by a wall. Resources 
 * are limited. Each day, you can install walls around only one region -- the affected area (continuous block of 
 * infected cells) that threatens the most uninfected cells the following night. There will never be a tie.<br>
 * 
 * Can you save the day? If so, what is the number of walls required? If not, and the world becomes fully infected, 
 * return the number of walls used.<br><br>
 * 
 * Note:<br>
 * 1. The number of rows and columns of grid will each be in the range [1, 50].<br>
 * 2. Each grid[i][j] will be either 0 or 1.<br>
 * 3. Throughout the described process, there is always a contiguous viral region that will infect strictly more 
 * uncontaminated squares in the next round.
 */
public class ContainVirus {
    
    public static int solution(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int walls = 0;
        Set<List<Integer>> checked = new HashSet<>();
        
        while (true) {
            Set<List<Integer>> virus = new HashSet<>();
            Set<Integer> affected = new HashSet<>();
            Set<List<Integer>> blockArea = new HashSet<>();            
            int wall = 0;
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    List<Integer> coordinate = new ArrayList<>();
                    coordinate.add(i);
                    coordinate.add(j);
                    if (!virus.contains(coordinate) && !checked.contains(coordinate)) {
                        Set<List<Integer>> block = new HashSet<>();
                        Set<Integer> aff = new HashSet<>();
                        int wal = dfs(grid, i, j, checked, block, aff);
                        virus.addAll(block);
                        if (aff.size() > affected.size()) {
                            affected = aff;
                            wall = wal;
                            blockArea = block;
                        }
                    }
                    
                }
            }
            
            if (wall == 0) {
                break;
            }
            
            walls += wall;
            for (List<Integer> cor : virus) {
                if (!blockArea.contains(cor)) {
                    int r = cor.get(0);
                    int c = cor.get(1);
                    if (r - 1 >= 0) {
                        grid[r-1][c] = 1;
                    }
                    if (r + 1 < m) {
                        grid[r+1][c] = 1;
                    }
                    if (c - 1 >= 0) {
                        grid[r][c-1] = 1;
                    }
                    if (c + 1 < n) {
                        grid[r][c+1] = 1;
                    }
                }
            }
            checked.addAll(blockArea);
        }
        
        return walls;        
    }
    
    private static int dfs(int[][] grid, int i, int j, Set<List<Integer>> checked, Set<List<Integer>> visited, Set<Integer> affected) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> coordinate = new ArrayList<>();
        coordinate.add(i);
        coordinate.add(j);
        
        if (i < 0 || i >= m || j < 0 || j >= n || visited.contains(coordinate) || checked.contains(coordinate)) {
            return 0;
        }
        if (grid[i][j] == 0) {
            affected.add(i * n + j);
            return 1;
        }
        visited.add(coordinate);
        
        return dfs(grid, i + 1, j, checked, visited, affected)
             + dfs(grid, i - 1, j, checked, visited, affected)
             + dfs(grid, i, j + 1, checked, visited, affected)
             + dfs(grid, i, j - 1, checked, visited, affected);        
    }
    
    public static void main(String[] args) {
        int[][] grid = { {0, 1, 0, 0, 0, 0, 0, 1},
                         {0, 1, 0, 0, 0, 0, 0, 1},
                         {0, 0, 0, 0, 0, 0, 0, 1},
                         {0, 0, 0, 0, 0, 0, 0, 0} };
        System.out.println(ContainVirus.solution(grid));
        
        int[][] grid2 = { {1, 1, 1},
                          {1, 0, 1},
                          {1, 1, 1} };
        System.out.println(ContainVirus.solution(grid2));
        
        int[][] grid3 = { {1, 1, 1, 0, 0, 0, 0, 0, 0},
                          {1, 0, 1, 0, 1, 1, 1, 1, 1},
                          {1, 1, 1, 0, 0, 0, 0, 0, 0} };
        System.out.println(ContainVirus.solution(grid3));
    }

}
