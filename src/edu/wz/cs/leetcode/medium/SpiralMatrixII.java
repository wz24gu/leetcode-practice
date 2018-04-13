package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 59. Spiral Matrix II<br>
 * https://leetcode.com/problems/spiral-matrix-ii<br><br>
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 */
public class SpiralMatrixII {
    
    public static int[][] solution(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = num++;
            }
            rowStart++;
            
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = num++;
            }
            colEnd--;
            
            if (rowStart <= rowEnd) {  // not needed here, but needed in m * n matrix
                for (int i = colEnd; i >= colStart; i--) {                
                    matrix[rowEnd][i] = num++;                
                }
            }
            rowEnd--;
            
            if (colStart <= colEnd) {  // not needed here, but needed in m * n matrix
                for (int i = rowEnd; i >= rowStart; i--) {                
                    matrix[i][colStart] = num++;                
                }
            }
            colStart++;
        }
        
        return matrix;
    }
    
    public static void main(String[] args) {
        int[][] matrix = SpiralMatrixII.solution(3);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
