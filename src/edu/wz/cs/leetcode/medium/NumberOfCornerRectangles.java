package edu.wz.cs.leetcode.medium;

/**
 * 750. Number Of Corner Rectangles<br>
 * https://leetcode.com/problems/number-of-corner-rectangles<br><br>
 * 
 * Given a grid where each entry is only 0 or 1, find the number of corner rectangles.<br>
 * 
 * A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need 
 * to have the value 1. Also, all four 1s used must be distinct.<br><br>
 * 
 * Note:<br>
 * 1. The number of rows and columns of grid will each be in the range [1, 200].<br>
 * 2. Each grid[i][j] will be either 0 or 1.<br>
 * 3. The number of 1s in the grid will be at most 6000.
 */
public class NumberOfCornerRectangles {
    
    public static int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int count = 0;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        count++;
                    }
                }
                res += count * (count - 1) / 2;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] grid = { {1, 0, 0, 1, 0},
                         {0, 0, 1, 0, 1},
                         {0, 0, 0, 1, 0},
                         {1, 0, 1, 0, 1} };
        System.out.println(NumberOfCornerRectangles.solution(grid));
        
        int[][] grid2 = { {1, 1, 1},
                          {1, 1, 1},
                          {1, 1, 1} };
        System.out.println(NumberOfCornerRectangles.solution(grid2));

        int[][] grid3 = { {1, 1, 1, 1} };
        System.out.println(NumberOfCornerRectangles.solution(grid3));
    }

}
