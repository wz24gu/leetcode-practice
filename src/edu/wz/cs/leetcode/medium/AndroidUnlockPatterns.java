package edu.wz.cs.leetcode.medium;

/**
 * 351. Android Unlock Patterns<br>
 * https://leetcode.com/problems/android-unlock-patterns<br><br>
 * 
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 <= m <= n <= 9, count the total number of unlock 
 * patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.<br><br>
 * 
 * Rules for a valid pattern:<br>
 * 1. Each pattern must connect at least m keys and at most n keys.<br>
 * 2. All the keys must be distinct.<br>
 * 3. If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have 
 * previously selected in the pattern. No jumps through non selected key is allowed.<br>
 * 4. The order of keys used matters.
 */
public class AndroidUnlockPatterns {
    
    public static int solution(int m, int n) {
        boolean[] marked = new boolean[10];
        
        int[][] cross = new int[10][10];
        cross[1][3] = cross[3][1] = 2;
        cross[4][6] = cross[6][4] = 5;
        cross[7][9] = cross[9][7] = 8;
        cross[1][7] = cross[7][1] = 4;
        cross[2][8] = cross[8][2] = 5;
        cross[3][9] = cross[9][3] = 6;
        cross[1][9] = cross[9][1] = cross[3][7] = cross[7][3] = 5;
        
        int result = 0;
        result += helper(1, 1, 0, m, n, cross, marked) * 4;  // 1, 3, 7, 9 are the same
        result += helper(2, 1, 0, m, n, cross, marked) * 4;  // 2, 4, 6, 8 are the same
        result += helper(5, 1, 0, m, n, cross, marked);
        
        return result;
    }
    
    private static int helper(int num, int len, int result, int m, int n, int[][] cross, boolean[] marked) {
        if (len >= m) {
            result++;
        }
        if (len == n) {
            return result;
        }
        
        marked[num] = true;
        for (int next = 1; next <= 9; next++) {
            if (num == next) {
                continue;
            }
            int c = cross[num][next];
            if (!marked[next] && (c == 0 || marked[c])) {
                result = helper(next, len + 1, result, m, n, cross, marked);
            }
        }
        marked[num] = false;
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(AndroidUnlockPatterns.solution(2, 2));  // 56
        System.out.println(AndroidUnlockPatterns.solution(1, 2));  // 65
    }

}
