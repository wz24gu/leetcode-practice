package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 498. Diagonal Traverse<br>
 * https://leetcode.com/problems/diagonal-traverse<br><br>
 * 
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown 
 * in the below image.<br>
 * 
 * Note: The total number of elements of the given matrix will not exceed 10,000.
 */
public class DiagonalTraverse {
    
    public static int[] solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {};
        }
        
        int[][] dirs = { {-1, 1}, {1, -1} };
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int i = 0;
        int j = 0;
        int d = 0;
        for (int k = 0; k < result.length; k++) {
            result[k] = matrix[i][j];
            
            i += dirs[d][0];
            j += dirs[d][1];
            if (i >= m) { i = m - 1; j += 2; d = 1 - d; }
            if (j >= n) { j = n - 1; i += 2; d = 1 - d; }
            if (i < 0) { i = 0; d = 1 - d; }
            if (j < 0) { j = 0; d = 1 - d; }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3},
                           {4, 5, 6},
                           {7, 8, 9} };
        System.out.println(Arrays.toString(DiagonalTraverse.solution(matrix)));
    }

}
