package edu.wz.cs.leetcode.medium;

/**
 * 240. Search a 2D Matrix II<br>
 * https://leetcode.com/problems/search-a-2d-matrix-ii<br><br>
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:<br>
 * 1. Integers in each row are sorted in ascending from left to right.<br>
 * 2. Integers in each column are sorted in ascending from top to bottom.
 */
public class Search2DMatrixII {
    
    public static boolean solution(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m-1][n-1]) {
            return false;
        }
        
        int x = m - 1;
        int y = 0;
        
        while (true) {
            if (matrix[x][y] > target) {
                x--;
            }
            else if (matrix[x][y] < target) {
                y++;
            }
            else {
                return true;
            }
            if (x < 0 || y >= n) {
                break;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {1, 4, 7, 11, 15},
                           {2, 5, 8, 12, 19},
                           {3, 6, 9, 16, 22},
                           {10, 13, 14, 17, 24},
                           {18, 21, 23, 26, 30} };
        System.out.println(Search2DMatrixII.solution(matrix, 5));
        System.out.println(Search2DMatrixII.solution(matrix, 20));
    }

}
