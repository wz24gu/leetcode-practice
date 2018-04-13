package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 305. Number of Islands II<br>
 * https://leetcode.com/problems/number-of-islands-ii<br><br>
 * 
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns 
 * the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after 
 * each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or 
 * vertically. You may assume all four edges of the grid are all surrounded by water.<br>
 * 
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
public class NumberOfIslandsII {
    
    // this implementation is not correct because islands may merge and number may decrease
    public static List<Integer> solution(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0) {
            return result;
        }
        
        int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        int[][] water = new int[m][n];
        
        int count = 0;
        for (int[] pos : positions) {
            int i = pos[0];
            int j = pos[1];
            
            if (i >= 0 && i < m && j >= 0 && j < n) {
                water[i][j] = 1;
                boolean valid = true;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && water[x][y] == 1) {
                        valid = false;
                        break;
                    }
                }
                
                if (valid) {
                    result.add(++count);
                }
                else {
                    result.add(count);
                }
            }
            else {
                // if the point is out side of the water, just add count
                result.add(count);
            }
        }
        
        return result;
    }
    
    public static List<Integer> solutionX(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (m <= 0 || n <= 0 || positions == null || positions.length == 0) {
            return result;
        }
        
        int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        
        int count = 0;
        int[] id = new int[m * n];
        Arrays.fill(id, -1);
        
        for (int[] pos : positions) {
            if (pos[0] < 0 || pos[0] >= m || pos[1] < 0 || pos[1] >= n) {
                continue;
            }
            
            int i = pos[0] * n + pos[1];
            id[i] = i;
            count++;
            
            for (int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                int j = x * n + y;
                if (x < 0 || x >= m || y < 0 || y >= n || id[j] == -1) {
                    continue;
                }
                
                int jRoot = find(id, j);
                if (jRoot != i) {
                    id[i] = j;
                    i = j;
                    count--;
                }
            }
            
            result.add(count);
        }
        
        return result;
    }
    
    private static int find(int[] id, int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];  // path compression
            i = id[i];
        }
        return i;
    }
    
    public static void main(String[] args) {
        int[][] positions = { {0, 0}, {0, 1}, {1, 2}, {2, 1} };
        System.out.println(NumberOfIslandsII.solutionX(3, 3, positions));
    }

}
