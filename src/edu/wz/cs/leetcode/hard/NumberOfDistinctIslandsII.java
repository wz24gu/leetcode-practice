package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 711. Number of Distinct Islands II<br>
 * https://leetcode.com/problems/number-of-distinct-islands-ii<br><br>
 * 
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally 
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.<br>
 * 
 * Count the number of distinct islands. An island is considered to be the same as another if they have the same shape, 
 * or have the same shape after rotation (90, 180, or 270 degrees only) or reflection (left/right direction or up/down 
 * direction).<br>
 * 
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class NumberOfDistinctIslandsII {
    
    private static int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    private static int[][] trans = { {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };
    
    public static int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<int[]> list = new ArrayList<>();
                    dfs(grid, i, j, list);
                    String mask = normalize(list);
                    set.add(mask);
                }
            }
        }
        
        return set.size();
    }
    
    private static void dfs(int[][] grid, int i, int j, List<int[]> list) {
        list.add(new int[] {i, j});
        grid[i][j] = -1;
        
        int m = grid.length;
        int n = grid[0].length;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                dfs(grid, x, y, list);
            }
        }
    }
    
    private static String normalize(List<int[]> list) {
        List<String> forms = new ArrayList<>();
        for (int[] t : trans) {
            List<int[]> list1 = new ArrayList<>();
            List<int[]> list2 = new ArrayList<>();
            for (int[] pos : list) {
                list1.add(new int[] {pos[0] * t[0], pos[1] * t[1]});
                list2.add(new int[] {pos[1] * t[1], pos[0] * t[0]});
            }
            forms.add(buildString(list1));
            forms.add(buildString(list2));
        }
        Collections.sort(forms);
        return forms.get(0);
    }
    
    private static String buildString(List<int[]> list) {
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        
        StringBuilder sb = new StringBuilder();
        int x = list.get(0)[0];
        int y = list.get(0)[1];
        for (int[] pos : list) {
            sb.append(pos[0] - x).append(":").append(pos[1] - y).append(":");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        int[][] grid = { {1, 1, 0, 0, 0},
                         {1, 0, 0, 0 ,0},
                         {0, 0, 0 ,0, 1},
                         {0, 0, 0, 1, 1}
                       };
        System.out.println(NumberOfDistinctIslandsII.solution(grid));
        
        int[][] grid2 = { {1, 1, 1, 0, 0},
                          {1, 0, 0, 0 ,1},
                          {0, 1, 0 ,0, 1},
                          {0, 1, 1, 1, 0} };
        System.out.println(NumberOfDistinctIslandsII.solution(grid2));
    }

}
