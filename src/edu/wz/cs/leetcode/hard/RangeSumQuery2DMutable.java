package edu.wz.cs.leetcode.hard;

/**
 * 308. Range Sum Query 2D - Mutable<br>
 * https://leetcode.com/problems/range-sum-query-2d-mutable<br><br>
 * 
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) 
 * and lower right corner (row2, col2).<br><br>
 * 
 * Note:<br>
 * 1. The matrix is only modifiable by the update function.<br>
 * 2. You may assume the number of calls to update and sumRegion function is distributed evenly.<br>
 * 3. You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DMutable {
    
    private int[][] tree;
    private int[][] nums;
    int m;
    int n;
    
    public RangeSumQuery2DMutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        m = matrix.length;
        n = matrix[0].length;
        tree = new int[m+1][n+1];
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) {
            return;
        }
        
        int delta = val - nums[row][col];
        for (int i = row + 1; i <= m; i += (i & (-i))) {
            for (int j = col + 1; j <= n; j += (j & (-j))) {
                tree[i][j] += delta;
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) {
            return 0;
        }
        return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
    }
    
    private int sum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= (i & (-i))) {
            for (int j = col; j > 0; j -= (j & (-j))) {
                sum += tree[i][j];
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {3, 0, 1, 4, 2},
                           {5, 6, 3, 2, 1},
                           {1, 2, 0, 1, 5},
                           {4, 1, 0, 1, 7},
                           {1, 0, 3, 0, 5} };
        RangeSumQuery2DMutable rangeSum = new RangeSumQuery2DMutable(matrix);
        System.out.println(rangeSum.sumRegion(2, 1, 4, 3));
        rangeSum.update(3, 2, 2);
        System.out.println(rangeSum.sumRegion(2, 1, 4, 3));
    }

}
