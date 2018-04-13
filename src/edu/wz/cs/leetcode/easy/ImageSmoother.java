package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 661. Image Smoother<br>
 * https://leetcode.com/problems/image-smoother<br>
 * 
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray
 * scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a
 * cell has less than 8 surrounding cells, then use as many as you can.<br><br>
 * 
 * Note:<br>
 * 1. The value in the given matrix is in the range of [0, 255].<br>
 * 2. The length and width of the given matrix are in the range of [1, 150].
 */
public class ImageSmoother {
    
    public static int[][] solution(int[][] M) {        
        int m = M.length;
        int n = M[0].length;
        int[][] result = new int[m][n];  // cannot change in places, need to create a new matrix
        
        int[][] dirs = { {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1} };
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = M[i][j];
                int count = 1;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        sum += M[x][y];
                        count++;
                    }
                }                
                result[i][j] = sum / count;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[][] M = { {1, 1, 1},
                      {1, 0, 1},
                      {1, 1, 1} };
        int[][] result = ImageSmoother.solution(M);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

}
