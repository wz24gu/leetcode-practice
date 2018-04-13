package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 656. Coin Path<br>
 * https://leetcode.com/problems/coin-path<br><br>
 * 
 * Given an array A (index starts at 1) consisting of N integers: A1, A2, ..., AN and an integer B. The integer B 
 * denotes that from any place (suppose the index is i) in the array A, you can jump to any one of the place in the 
 * array A indexed i+1, i+2, ..., i+B if this place can be jumped to. Also, if you step on the index i, you have to pay 
 * Ai coins. If Ai is -1, it means you can't jump to the place indexed i in the array.<br>
 * 
 * Now, you start from the place indexed 1 in the array A, and your aim is to reach the place indexed N using the 
 * minimum coins. You need to return the path of indexes (starting from 1 to N) in the array you should take to get to 
 * the place indexed N using minimum coins.<br>
 * 
 * If there are multiple paths with the same cost, return the lexicographically smallest such path.<br>
 * 
 * If it's not possible to reach the place indexed N then you need to return an empty array.<br><br>
 * 
 * Note:<br>
 * 1. Path Pa1, Pa2, ..., Pan is lexicographically smaller than Pb1, Pb2, ..., Pbm, if and only if at the first i where 
 * Pai and Pbi differ, Pai < Pbi; when no such i exists, then n < m.<br>
 * 2. A1 >= 0. A2, ..., AN (if exist) will in the range of [-1, 100].<br>
 * 3. Length of A is in the range of [1, 1000].<br>
 * B is in the range of [1, 100].
 */
public class CoinPath {
    
    public static List<String> solution(int[] A, int B) {
        List<String> result = new ArrayList<>();
        if (A == null || A.length == 0 || A[A.length-1] == -1) {
            return result;
        }
        
        int n = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[] pos = new int[n];
        Arrays.fill(pos, -1);
        
        // jump from end to start
        dp[n-1] = A[n-1];
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] == -1) {
                continue;
            }
            for (int j = i + 1; j <= Math.min(i + B, n - 1); j++) {
                if (dp[j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (A[i] + dp[j] < dp[i]) {
                    dp[i] = A[i] + dp[j];
                    pos[i] = j;
                }
            }
        }
        
        if (dp[0] == Integer.MAX_VALUE) {
            return result;
        }
        for (int curr = 0; curr != -1; curr = pos[curr]) {
            result.add(curr + 1 + "");
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 4, -1, 2};
        System.out.println(CoinPath.solution(A, 2));
        
        int[] A2 = {1, 2, 4, -1, 2};
        System.out.println(CoinPath.solution(A2, 1));
    }

}
