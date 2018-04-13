package edu.wz.cs.leetcode.medium;

/**
 * 799. Champagne Tower<br>
 * https://leetcode.com/problems/champagne-tower<br><br>
 * 
 * We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 
 * 100th row.  Each glass holds one cup (250ml) of champagne.<br>
 * 
 * Then, some champagne is poured in the first glass at the top. When the top most glass is full, any excess liquid 
 * poured will fall equally to the glass immediately to the left and right of it. When those glasses become full, any 
 * excess champagne will fall equally to the left and right of those glasses, and so on.  (A glass at the bottom row 
 * has it's excess champagne fall on the floor.)<br>
 * 
 * For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are poured, 
 * the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups become full 
 * - there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the middle glass half 
 * full, and the two outside glasses are a quarter full, as pictured below.<br>
 * 
 * Now after pouring some non-negative integer cups of champagne, return how full the j-th glass in the i-th row is (both 
 * i and j are 0 indexed.)<br><br>
 * 
 * Note:<br>
 * 1. poured will be in the range of [0, 10 ^ 9].<br>
 * 2. query_glass and query_row will be in the range of [0, 99].
 */
public class ChampagneTower {
    
    public static double solution(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1) {
                    double excess = (dp[i][j] - 1) / 2.0;
                    dp[i+1][j] += excess;
                    dp[i+1][j+1] += excess;
                    dp[i][j] = 1;
                }
            }
        }
        return dp[query_row][query_glass];
    }
    
    public static void main(String[] args) {
        System.out.println(ChampagneTower.solution(2, 0, 0));
        System.out.println(ChampagneTower.solution(1, 1, 1));
        System.out.println(ChampagneTower.solution(2, 1, 1));
    }

}
