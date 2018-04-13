package edu.wz.cs.leetcode.hard;

/**
 * 546. Remove Boxes<br/>
 * https://leetcode.com/problems/remove-boxes<br/><br/>
 * 
 * Given several boxes with different colors represented by different positive numbers.<br/>
 * 
 * You may experience several rounds to remove boxes until there is no box left. Each time you can choose some 
 * continuous boxes with the same color (composed of k boxes, k >= 1), remove them and get k * k points. Find the 
 * maximum points you can get.<br/>
 * 
 * Note: The number of boxes n would not exceed 100.
 */
public class RemoveBoxes {
    
    public static int solutionBU(int[] boxes) {
        int n = boxes.length;
        if (n == 0) {
            return 0;
        }
        
        int[][][] dp = new int[n][n][n];
        
        for (int j = 0; j < n; j++) {
            for (int k = 0; k <= j; k++) {
                dp[j][j][k] = (k + 1) * (k + 1);
            }
        }
        
        for (int l = 1; l < n; l++) {
            for (int j = l; j < n; j++) {
                int i = j - l;
                
                for (int k = 0; k <= i; k++) {
                    int result = (k + 1) * (k + 1) + dp[i+1][j][0];
                    
                    for (int m = i + 1; m <= j; m++) {
                        if (boxes[m] == boxes[i]) {
                            result = Math.max(result, dp[i+ 1][m-1][0] + dp[m][j][k+1]);
                        }
                    }
                    dp[i][j][k] = result;
                }
            }
        }
        
        return dp[0][n-1][0];        
    }
    
    public static int solutionTD(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return helper(boxes, 0, n - 1, 0, dp);
    }
    
    private static int helper(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j][k] > 0) {
            return dp[i][j][k];
        }
        
        int result = (k + 1) * (k + 1) + helper(boxes, i + 1, j, 0, dp);
        for (int m = i + 1; m <= j; m++) {
            if (boxes[m] == boxes[i]) {
                result = Math.max(result, helper(boxes, i + 1, m - 1, 0, dp) + helper(boxes, m, j, k + 1, dp));
            }
        }
        dp[i][j][k] = result;
        return result;
    }
    
    public static void main(String[] args) {
        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        System.out.println(RemoveBoxes.solutionBU(boxes));
        System.out.println(RemoveBoxes.solutionTD(boxes));
    }

}
