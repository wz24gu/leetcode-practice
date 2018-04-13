package edu.wz.cs.leetcode.medium;

/**
 * 789. Escape The Ghosts<br>
 * https://leetcode.com/problems/escape-the-ghosts<br><br>
 * 
 * You are playing a simplified Pacman game. You start at the point (0, 0), and your destination is (target[0], 
 * target[1]). There are several ghosts on the map, the i-th ghost starts at (ghosts[i][0], ghosts[i][1]).<br>
 * 
 * Each turn, you and all ghosts simultaneously *may* move in one of 4 cardinal directions: north, east, west, or south, 
 * going from the previous point to a new point 1 unit of distance away.<br>
 * 
 * You escape if and only if you can reach the target before any ghost reaches you (for any given moves the ghosts may 
 * take.)  If you reach any square (including the target) at the same time as a ghost, it doesn't count as an escape.<br>
 * 
 * Return True if and only if it is possible to escape.<br><br>
 * 
 * Note:<br>
 * 1. All points have coordinates with absolute value <= 10000.<br>
 * 2. The number of ghosts will not exceed 100.
 */
public class EscapeTheGhosts {
    
    public static boolean solution(int[][] ghosts, int[] target) {
        int max = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int d = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (d <= max) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[][] ghosts = { {1, 0}, {0, 3} };
        int[] target = {0, 1};
        System.out.println(EscapeTheGhosts.solution(ghosts, target));
        
        int[][] ghosts2 = { {1, 0} };
        int[] target2 = {2, 0};
        System.out.println(EscapeTheGhosts.solution(ghosts2, target2));
        
        int[][] ghosts3 = { {2, 0} };
        int[] target3 = {1, 0};
        System.out.println(EscapeTheGhosts.solution(ghosts3, target3));
    }

}
