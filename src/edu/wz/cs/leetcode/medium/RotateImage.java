package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 48. Rotate Image<br>
 * https://leetcode.com/problems/rotate-image<br><br>
 * 
 * You are given an n x n 2D matrix representing an image.<br>
 * 
 * Rotate the image by 90 degrees (clockwise).<br>
 * 
 * Note: You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT 
 * allocate another 2D matrix and do the rotation.
 */
public class RotateImage {
    
    public static void solution(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }        
    }
    
    public static void solutionX(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = tmp;
            }
        }
        
        for (int i = 0; i < n / 2; i++) {  // up and down for clock wise, left and right for counter clock wise
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = tmp;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3},
                           {4, 5, 6},
                           {7, 8, 9} };
        RotateImage.solution(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        
        int[][] matrix2 = { {5, 1, 9, 11},
                            {2, 4, 8, 10},
                            {13, 3, 6, 7},
                            {15, 14, 12, 16} };
        RotateImage.solution(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }
        
        int[][] matrix3 = { {5, 1, 9, 11},
                            {2, 4, 8, 10},
                            {13, 3, 6, 7},
                            {15, 14, 12, 16} };
        RotateImage.solutionX(matrix3);
        for (int i = 0; i < matrix3.length; i++) {
            System.out.println(Arrays.toString(matrix3[i]));
        }
    }

}
