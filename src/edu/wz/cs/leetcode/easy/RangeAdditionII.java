package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 598. Range Addition II<br>
 * https://leetcode.com/problems/range-addition-ii<br><br>
 * 
 * Given an m * n matrix M initialized with all 0's and several update operations. Operations are represented by a 2D
 * array, and each operation is represented by an array with two positive integers a and b, which means M[i][j] should
 * be added by one for all 0 <= i < a and 0 <= j < b.<br>
 * 
 * You need to count and return the number of maximum integers in the matrix after performing all the operations.<br><br>
 * 
 * Note:<br>
 * 1. The range of m and n is [1,40000].<br>
 * 2. The range of a is [1,m], and the range of b is [1,n].<br>
 * 3. The range of operations size won't exceed 10,000.
 */
public class RangeAdditionII {
    
    public static int solution(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;  // tricky
        }
        
        int minM = Integer.MAX_VALUE;
        int minN = Integer.MAX_VALUE;
        for (int[] op : ops) {
            minM = Math.min(minM, op[0]);
            minN = Math.min(minN, op[1]);
        }
        return minM * minN;
    }
    
    public static int solutionAlt(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;  // tricky
        }
        
        Arrays.sort(ops, (a, b) -> a[0] - b[0]);
        int x = ops[0][0];
        Arrays.sort(ops, (a, b) -> a[1] - b[1]);
        int y = ops[0][1];
        return x * y;
    }
    
    public static void main(String[] args) {
        int[][] ops = {{2, 2}, {3, 3}};
        System.out.println(RangeAdditionII.solution(3, 3, ops));
        System.out.println(RangeAdditionII.solutionAlt(3, 3, ops));
    }

}
