package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 764. Largest Plus Sign<br>
 * https://leetcode.com/problems/largest-plus-sign<br><br>
 * 
 * In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except those cells in the given list mines which 
 * are 0. What is the largest axis-aligned plus sign of 1s contained in the grid? Return the order of the plus sign. If 
 * there is none, return 0.<br>
 * 
 * An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 along with 4 arms of length k-1 going up, 
 * down, left, and right, and made of 1s. This is demonstrated in the diagrams below. Note that there could be 0s or 1s 
 * beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1s.<br><br>
 * 
 * Note:<br>
 * 1. N will be an integer in the range [1, 500].<br>
 * 2. mines will have length at most 5000.<br>
 * 3. mines[i] will be length 2 and consist of integers in the range [0, N-1].
 */
public class LargestPlusSign {
    
    public static int solution(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], 1);
        }
        
        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }
        
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    int count = 1;
                    int dir = 1;
                    while (i + dir < N && i - dir >= 0 && j + dir < N && j - dir >= 0
                            && grid[i + dir][j] == 1 && grid[i - dir][j] == 1
                            && grid[i][j + dir] == 1 && grid[i][j - dir] == 1) {
                        count++;
                        dir++;
                    }
                    res = Math.max(res, count);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] mines = { {4, 2} };
        System.out.println(LargestPlusSign.solution(5, mines));
        
        int[][] mines2 = { };
        System.out.println(LargestPlusSign.solution(2, mines2));
        
        int[][] mines3 = { {0, 0} };
        System.out.println(LargestPlusSign.solution(1, mines3));
    }

}
