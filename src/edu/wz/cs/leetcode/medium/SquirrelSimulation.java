package edu.wz.cs.leetcode.medium;

/**
 * 573. Squirrel Simulation<br>
 * https://leetcode.com/problems/squirrel-simulation<br><br>
 * 
 * There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. Your goal is to 
 * find the minimal distance for the squirrel to collect all the nuts and put them under the tree one by one. The 
 * squirrel can only take at most one nut at one time and can move in four directions - up, down, left and right, to 
 * the adjacent cell. The distance is represented by the number of moves.<br><br>
 * 
 * Note:<br>
 * 1. All given positions won't overlap.<br>
 * 2. The squirrel can take at most one nut at one time.<br>
 * 3. The given positions of nuts have no order.<br>
 * 4. Height and width are positive integers. 3 <= height * width <= 10,000.<br>
 * 5. The given positions contain at least one nut, only one tree and one squirrel.
 */
public class SquirrelSimulation {
    
    /**
     * x is tree2nut, y is squirrel2nut
     * if the squirrel does not pick nuts[i], dist is 2 * x, otherwise the dist is x + y
     * find a nuts[i] whose x * 2 - (x + y) is the maximum, diff is x - y
     */
    public static int solution(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int result = 0;
        int maxDiff = Integer.MIN_VALUE;
        
        for (int[] nut : nuts) {
            int tree2nut = Math.abs(tree[0] - nut[0]) + Math.abs(tree[1] - nut[1]);
            result += tree2nut * 2;
            
            int squirrel2nut = Math.abs(squirrel[0] - nut[0]) + Math.abs(squirrel[1] - nut[1]);
            maxDiff = Math.max(maxDiff, tree2nut - squirrel2nut);
        }
        
        return result - maxDiff;
    }
    
    public static void main(String[] args) {
        int[] tree = {2, 2};
        int[] squirrel = {4, 4};
        int[][] nuts = {{3, 0}, {2, 5}};
        System.out.println(SquirrelSimulation.solution(5, 7, tree, squirrel, nuts));
    }

}
