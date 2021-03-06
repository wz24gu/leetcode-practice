package edu.wz.cs.leetcode.medium;

import java.util.PriorityQueue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix<br>
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix<br><br>
 * 
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element 
 * in the matrix.<br>
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.<br>
 * 
 * Note: You may assume k is always valid, 1 <= k <= n^2.
 */
public class KthSmallestElementInSortedMatrix {

    public static int solution(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);  // max heap
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                queue.offer(matrix[i][j]);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }
    
    public static int solutionBS(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int lo = matrix[0][0];
        int hi = matrix[row - 1][col - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0; int j = col - 1;
            for (int i = 0; i < row; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < k) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        
        return lo;
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {1, 5, 9},
                           {10, 11, 13},
                           {12, 13, 15} };
        System.out.println(KthSmallestElementInSortedMatrix.solution(matrix, 8));
        System.out.println(KthSmallestElementInSortedMatrix.solutionBS(matrix, 8));
    }
}
