package edu.wz.cs.leetcode.medium;

/**
 * 808. Soup Servings<br>
 * https://leetcode.com/problems/soup-servings<br><br>
 * 
 * There are two types of soup: type A and type B. Initially we have N ml of each type of soup. There are four kinds of 
 * operations:<br>
 * 1. Serve 100 ml of soup A and 0 ml of soup B<br>
 * 2. Serve 75 ml of soup A and 25 ml of soup B<br>
 * 3. Serve 50 ml of soup A and 50 ml of soup B<br>
 * 4. Serve 25 ml of soup A and 75 ml of soup B<br>
 * 
 * When we serve some soup, we give it to someone and we no longer have it.  Each turn, we will choose from the four 
 * operations with equal probability 0.25. If the remaining volume of soup is not enough to complete the operation, we 
 * will serve as much as we can.  We stop once we no longer have some quantity of both types of soup.<br>
 * 
 * Note that we do not have the operation where all 100 ml's of soup B are used first.<br>
 * 
 * Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the 
 * same time.<br><br>
 * 
 * Notes:<br>
 * 1. 0 <= N <= 10^9.<br>
 * 2. Answers within 10^-6 of the true value will be accepted as correct.
 */
public class SoupServings {
    
    private static double[][] dp = new double[200][200];
    
    public static double solution(int N) {
        if (N >= 5000) {
            return 1.0;
        }
        int M = (N + 24) / 25;
        return helper(M, M);
    }
    
    private static double helper(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0.0;
        }
        if (dp[a][b] > 0) {
            return dp[a][b];
        }
        
        dp[a][b] = 0.25 * (helper(a - 4, b) + helper(a - 3, b - 1) + helper(a - 2, b - 2) + helper(a - 1, b - 3));
        return dp[a][b];
    }

    public static void main(String[] args) {
        System.out.println(SoupServings.solution(50));
    }
    
}
