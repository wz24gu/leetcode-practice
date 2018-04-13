package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 Matrix<br>
 * https://leetcode.com/problems/01-matrix<br><br>
 * 
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.<br>
 * 
 * The distance between two adjacent cells is 1.<br><br>
 * 
 * Note:<br>
 * 1. The number of elements of the given matrix will not exceed 10,000.<br>
 * 2. There are at least one 0 in the given matrix.<br>
 * 3. The cells are adjacent in only four directions: up, down, left and right.
 */
public class ZeroOneMatrix {
    
    public static int[][] solution(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        
        // put all 0 in a queue, and change 1 to integer max
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            for (int[] dir : dirs) {
                int x = t[0] + dir[0];
                int y = t[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[t[0]][t[1]]) {
                    continue;
                }
                matrix[x][y] = matrix[t[0]][t[1]] + 1;
                queue.add(new int[] {x, y});
            }
        }
        
        return matrix;
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {0, 0, 0},
                           {0, 1, 0},
                           {0, 0, 0} };
        matrix = ZeroOneMatrix.solution(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        
        int[][] matrix2 = { {0, 0, 0},
                           {0, 1, 0},
                           {1, 1, 1} };
        matrix2 = ZeroOneMatrix.solution(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }
    }

}
