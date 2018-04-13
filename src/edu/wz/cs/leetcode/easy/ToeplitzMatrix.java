package edu.wz.cs.leetcode.easy;

/**
 * 766. Toeplitz Matrix<br>
 * https://leetcode.com/problems/toeplitz-matrix<br><br>
 * 
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.<br>
 * 
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.<br><br>
 * 
 * Note:<br>
 * 1. matrix will be a 2D array of integers.<br>
 * 2. matrix will have a number of rows and columns in range [1, 20].<br>
 * 3. matrix[i][j] will be integers in range [0, 99].
 */
public class ToeplitzMatrix {
    
    public static boolean solution(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            int val = matrix[i][0];
            if (!valid(matrix, i, 0, val)) {
                return false;
            }
        }
        
        for (int j = 1; j < n; j++) {
            int val = matrix[0][j];
            if (!valid(matrix, 0, j, val)) {
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean valid(int[][] matrix, int i, int j, int val) {
        int m = matrix.length;
        int n = matrix[0].length;
        while (i < m && j < n) {
            if (matrix[i][j] != val) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3, 4},
                           {5, 1, 2, 3},
                           {9, 5, 1, 2} };
        System.out.println(ToeplitzMatrix.solution(matrix));
        
        int[][] matrix2 = { {1, 2},
                            {2, 2} };
        System.out.println(ToeplitzMatrix.solution(matrix2));        
    }

}
