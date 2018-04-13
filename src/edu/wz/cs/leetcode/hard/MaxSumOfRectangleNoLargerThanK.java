package edu.wz.cs.leetcode.hard;

import java.util.TreeSet;

/**
 * 363. Max Sum of Rectangle No Larger Than K<br>
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k<br><br>
 * 
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum 
 * is no larger than k.<br><br>
 * 
 * Note:<br>
 * 1. The rectangle inside the matrix must have an area > 0.<br>
 * 2. What if the number of rows is much larger than the number of columns?
 */
public class MaxSumOfRectangleNoLargerThanK {
    
    public static int solution(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m][n];
        int result = Integer.MIN_VALUE;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = matrix[i][j];
                if (i > 0) {
                    t += sum[i-1][j];
                }
                if (j > 0) {
                    t += sum[i][j-1];
                }
                if (i > 0 && j > 0) {
                    t -= sum[i-1][j-1];
                }
                sum[i][j] = t;
                
                for (int r = 0; r <= i; r++) {
                    for (int c = 0; c <= j; c++) {
                        int d = sum[i][j];
                        if (r > 0) {
                            d -= sum[r-1][j];
                        }
                        if (c > 0) {
                            d -= sum[i][c-1];
                        }
                        if (r > 0 && c > 0) {
                            d += sum[r-1][c-1];
                        }
                        if (d <= k) {
                            result = Math.max(result, d);
                        }
                    }
                }                
            }
        }
        
        return result;        
    }
    
    public static int solutionX(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int m = Math.min(row, col);
        int n = Math.max(row, col);
        
        boolean c = col > row;
        int result = Integer.MIN_VALUE;
        
        for (int i = 0; i < m; i++) {
            int[] array = new int[n];
            for (int j = i; j >= 0; j--) {
                int val = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                // traverse every column and row and sum up
                for (int k = 0; k < n; k++) {
                    array[k] = array[k] + (c ? matrix[j][k] : matrix[k][j]);
                    val = val + array[k];
                    // use tree set to binary search previous sum to get possible result
                    Integer sub = set.ceiling(val - target);
                    if (sub != null) {
                        result = Math.max(result, val - sub);
                    }
                    set.add(val);
                }
            }
        }
        
        return result;    
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {1, 0, 1}, {0, -2, 3} };
        System.out.println(MaxSumOfRectangleNoLargerThanK.solution(matrix, 2));
        System.out.println(MaxSumOfRectangleNoLargerThanK.solutionX(matrix, 2));
    }

}
