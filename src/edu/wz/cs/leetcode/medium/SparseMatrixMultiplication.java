package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 311. Sparse Matrix Multiplication<br/>
 * 
 * Given two sparse matrices A and B, return the result of AB.<br/>
 * 
 * You may assume that A's column number is equal to B's row number.
 */
public class SparseMatrixMultiplication {
    
    public static int[][] solution(int[][] A, int[][] B) {
        int mA = A.length;
        int nA = A[0].length;        
        int nB = B[0].length;        
        int[][] C = new int[mA][nB];
        
        for (int i = 0; i < mA; i++) {
            for (int k = 0; k < nA; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        if (B[k][j] != 0) {
                            C[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        
        return C;
    }
    
    @SuppressWarnings("unchecked")
    public static int[][] solutionAlt(int[][] A, int[][] B) {
        int mA = A.length;
        int nA = A[0].length;
        int nB = B[0].length;        
        
        List<Integer>[] indexA = (List<Integer>[]) new List[mA];  // java does not support generic array creation
        for (int i = 0; i < mA; i++) {
            List<Integer> numA = new ArrayList<>();
            for (int j = 0; j < nA; j++) {
                if (A[i][j] != 0) {
                    numA.add(j);
                    numA.add(A[i][j]);
                }
            }
            indexA[i] = numA;
        }
        
        int[][] C = new int[mA][nB];
        for (int i = 0; i < mA; i++) {
            List<Integer> numA = indexA[i];
            int size = numA.size();
            for (int k = 0; k < size - 1; k += 2) {
                int colA = numA.get(k);
                int valA = numA.get(k + 1);
                for (int j = 0; j < nB; j++) {
                    int valB = B[colA][j];
                    C[i][j] += valA * valB;
                }
            }
        }        
        return C;
    }

}
