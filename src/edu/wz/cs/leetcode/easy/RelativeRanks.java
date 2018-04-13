package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 506. Relative Ranks<br>
 * https://leetcode.com/problems/relative-ranks<br><br>
 * 
 * Given scores of N athletes, find their relative ranks and the people with the top three highest score, who will be
 * awarded medals: "Gold Medal", "Silver Medal", and "Bronze Medal".<br><br>
 * 
 * Note:<br>
 * 1. N is a positive integer and won't exceed 10,000.<br>
 * 2. All the scores of athletes are guaranteed to be unique.
 */
public class RelativeRanks {

    public static String[] solution(int[] nums) {
        int n = nums.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = nums[i];  // store number
            pair[i][1] = i;  // store position
        }
        
        Arrays.sort(pair, (a, b) -> b[0] - a[0]);
        
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[pair[i][1]] = "Gold Medal";
            }
            else if (i == 1) {
                result[pair[i][1]] = "Silver Medal";
            }
            else if (i == 2) {
                result[pair[i][1]] = "Bronze Medal";
            }
            else {
                result[pair[i][1]] = (i + 1) + "";
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] scores = {5, 6, 4, 1, 3, 2};
        System.out.println(Arrays.toString(RelativeRanks.solution(scores)));
    }

}
