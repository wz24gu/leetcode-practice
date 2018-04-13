package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 73. Set Matrix Zeroes<br>
 * https://leetcode.com/problems/set-matrix-zeroes<br><br>
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class SetMatrixZeroes {
    
    public static void solution(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;        
        int col0 = 1;
        
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {1, 1, 1},
                           {0, 1, 0},
                           {0, 1, 0} };
        SetMatrixZeroes.solution(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        
    }
    

}
