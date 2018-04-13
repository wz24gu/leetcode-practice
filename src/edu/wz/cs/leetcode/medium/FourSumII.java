package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II<br>
 * https://leetcode.com/problems/4sum-ii<br><br>
 * 
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that 
 * A[i] + B[j] + C[k] + D[l] is zero.<br>
 * 
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 <= N <= 500. All integers are in the 
 * range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 */
public class FourSumII {
    
    public static int solution(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                }
                else {
                    map.put(sum, 1);
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (map.containsKey(-sum)) {
                    count += map.get(-sum);
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        System.out.println(FourSumII.solution(A, B, C, D));
    }

}
