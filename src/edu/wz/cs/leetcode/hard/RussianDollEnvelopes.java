package edu.wz.cs.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. Russian Doll Envelopes<br>
 * https://leetcode.com/problems/russian-doll-envelopes<br><br>
 * 
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into 
 * another if and only if both the width and height of one envelope is greater than the width and height of the other 
 * envelope.<br>
 * 
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)<br>
 * 
 * Example: Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 
 * ([2,3] => [5,4] => [6,7]).
 */
public class RussianDollEnvelopes {
    
    public static int solution(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        
        // sort by width and then height
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] == e2[0]) {
                    return e1[1] - e2[1];
                }
                return e1[0] - e2[0];
            }
        });        
        
        int result = 0;
        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[][] envelopes = { {5, 4}, {6, 4}, {6, 7}, {2, 3} };
        System.out.println(RussianDollEnvelopes.solution(envelopes));
    }

}
