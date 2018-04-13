package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 566. Reshape the Matrix<br>
 * https://leetcode.com/problems/reshape-the-matrix<br><br>
 * 
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different
 * size but keep its original data. You're given a matrix represented by a two-dimensional array, and two positive
 * integers r and c representing the row number and column number of the wanted reshaped matrix, respectively. The
 * reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as
 * they were. If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix;
 * Otherwise, output the original matrix.<br><br>
 * 
 * Note:<br>
 * 1. The height and width of the given matrix is in range [1, 100].<br>
 * 2. The given r and c are all positive.
 */
public class ReshapeMatrix {

    public static int[][] solution(int[][] nums, int r, int c) {        
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        
        int[][] result = new int[r][c];
        int N = r * c;
        for (int i = 0; i < N; i++) {
            result[i / c][i % c] = nums[i / col][i % col];
        }
        return result;
    }
    
    public static int[][] solutionAlt(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        
        int[][] result = new int[r][c];
        int a = 0, b = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = nums[a][b++];
                if (b == col) {
                    a++;
                    b = 0;
                }
            }
        }
        
        return result;        
    }
    
    public static void main(String[] args) {
        int[][] nums = { {1, 2}, {3, 4} };
        int[][] result = ReshapeMatrix.solution(nums, 1, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        
        }
        int[][] result2 = ReshapeMatrix.solutionAlt(nums, 1, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result2[i]));
        }
    }
    
}
