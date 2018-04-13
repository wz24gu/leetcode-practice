package edu.wz.cs.leetcode.medium;

/**
 * 74. Search a 2D Matrix<br>
 * https://leetcode.com/problems/search-a-2d-matrix<br><br>
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:<br>
 * 1. Integers in each row are sorted from left to right.<br>
 * 2. The first integer of each row is greater than the last integer of the previous row.
 */
public class Search2DMatrix {
    
    public static boolean solution(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        if (target < matrix[0][0] || target > matrix[m-1][n-1]) {
            return false;
        }
        
        // binary search
        int lo = 0;
        int hi = m * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int k = matrix[mid / n][mid % n];
            if (k < target) {
                lo = mid + 1;
            }
            else if (k > target) {
                hi = mid - 1;
            }
            else {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {1, 3, 5, 7},
                           {10, 11, 16, 20},
                           {23, 30, 34, 50} };
        System.out.println(Search2DMatrix.solution(matrix, 3));
    }

}
