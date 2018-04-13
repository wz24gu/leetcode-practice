package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix<br>
 * https://leetcode.com/problems/spiral-matrix<br><br>
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {
    
    public static List<Integer> solution(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int rMin = 0;
        int rMax = matrix.length - 1;
        int cMin = 0;
        int cMax = matrix[0].length - 1;
        
        while (rMin <= rMax && cMin <= cMax) {
            for (int i = cMin; i <= cMax; i++) {
                result.add(matrix[rMin][i]);
            }
            rMin++;
            
            for (int i = rMin; i <= rMax; i++) {
                result.add(matrix[i][cMax]);
            }
            cMax--;
            
            if (rMin > rMax || cMin > cMax) {
                break;
            }
            
            for (int i = cMax; i >= cMin; i--) {
                result.add(matrix[rMax][i]);
            }
            rMax--;
            
            for (int i = rMax; i >= rMin; i--) {
                result.add(matrix[i][cMin]);
            }
            cMin++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3},
                           {4, 5, 6},
                           {7, 8, 9} };
        System.out.println(SpiralMatrix.solution(matrix));
    }

}
