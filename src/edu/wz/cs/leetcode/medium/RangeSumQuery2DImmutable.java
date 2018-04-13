package edu.wz.cs.leetcode.medium;

/**
 * 304. Range Sum Query 2D - Immutable<br>
 * https://leetcode.com/problems/range-sum-query-2d-immutable<br><br>
 * 
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) 
 * and lower right corner (row2, col2).<br><br>
 * 
 * Note:<br>
 * 1. You may assume that the matrix does not change.<br>
 * 2. There are many calls to sumRegion function.<br>
 * 3. You may assume that row1 <= row2 and col1 <= col2.
 */
public class RangeSumQuery2DImmutable {
    
    private int[][] sum;
    
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m+1][n+1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null) {
            return 0;
        }
        return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {3, 0, 1, 4, 2},
                           {5, 6, 3, 2, 1},
                           {1, 2, 0, 1, 5},
                           {4, 1, 0, 1, 7},
                           {1, 0, 3, 0, 5} };
        RangeSumQuery2DImmutable rangeSumQuery2DImmutable = new RangeSumQuery2DImmutable(matrix);
        System.out.println(rangeSumQuery2DImmutable.sumRegion(2, 1, 4, 3));
        System.out.println(rangeSumQuery2DImmutable.sumRegion(1, 1, 2, 2));
        System.out.println(rangeSumQuery2DImmutable.sumRegion(1, 2, 2, 4));        
    }

}
