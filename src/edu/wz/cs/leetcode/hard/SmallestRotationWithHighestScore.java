package edu.wz.cs.leetcode.hard;

/**
 * 798. Smallest Rotation with Highest Score<br>
 * https://leetcode.com/problems/smallest-rotation-with-highest-score<br><br>
 * 
 * Given an array A, we may rotate it by a non-negative integer K so that the array becomes A[K], A[K+1], A{K+2], ... 
 * A[A.length - 1], A[0], A[1], ..., A[K-1].  Afterward, any entries that are less than or equal to their index are 
 * worth 1 point.<br>
 * 
 * For example, if we have [2, 4, 1, 3, 0], and we rotate by K = 2, it becomes [1, 3, 0, 2, 4].  This is worth 3 points 
 * because 1 > 0 [no points], 3 > 1 [no points], 0 <= 2 [one point], 2 <= 3 [one point], 4 <= 4 [one point].<br>
 * 
 * Over all possible rotations, return the rotation index K that corresponds to the highest score we could receive. If 
 * there are multiple answers, return the smallest such index K.<br><br>
 * 
 * Note:<br>
 * 1. A will have length at most 20000.<br>
 * 2. A[i] will be in the range [0, A.length].
 */
public class SmallestRotationWithHighestScore {
    
    public static int solution(int[] A) {
        int n = A.length;
        int[] change = new int[n];
        for (int i = 0; i < n; i++) {
            change[(i - A[i] + 1 + n) % n] -= 1;
        }
        
        int max_i = 0;
        for (int i = 1; i < n; i++) {
            change[i] += change[i-1] + 1;
            max_i = change[i] > change[max_i] ? i : max_i;
        }
        return max_i;
    }
    
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 4, 0};
        System.out.println(SmallestRotationWithHighestScore.solution(A));
        
        int[] A2 = {1, 3, 0, 2, 4};
        System.out.println(SmallestRotationWithHighestScore.solution(A2));
    }

}
