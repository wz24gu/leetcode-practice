package edu.wz.cs.leetcode.medium;

/**
 * 547. Friend Circles<br>
 * https://leetcode.com/problems/friend-circles<br><br>
 * 
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in 
 * nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. 
 * And we defined a friend circle is a group of students who are direct or indirect friends.<br>
 * 
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the 
 * ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of 
 * friend circles among all the students.<br><br>
 * 
 * Note:<br>
 * 1. N is in range [1,200].<br>
 * 2. M[i][i] = 1 for all students.<br>
 * 3. If M[i][j] = 1, then M[j][i] = 1.
 */
public class FriendCircles {

    public static int solution(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        
        int n = M.length;
        boolean[] marked = new boolean[n];
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                dfs(M, marked, i);
                result++;
            }
        }
        return result;
    }
    
    private static void dfs(int[][] M, boolean[] marked, int i) {
        marked[i] = true;
        int n = M[0].length;
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1 && !marked[j]) {
                dfs(M, marked, j);
            }
        }
    }
    
    public static int solutionAlt(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        
        int n = M.length;
        int result = n;
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    int root1 = getId(id, i);
                    int root2 = getId(id, j);
                    if (root1 != root2) {
                        result--;
                        id[root1] = root2;
                    }
                }
            }
        }
        return result;
    }
    
    private static int getId(int[] id, int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];  // path compression
            i = id[i];
        }
        return i;
    }
    
    public static void main(String[] args) {
        int[][] M = { {1, 1, 0},
                      {1, 1, 0},
                      {0, 0, 1} };
        System.out.println(FriendCircles.solution(M));
        System.out.println(FriendCircles.solutionAlt(M));
        
        int[][] M2 = { {1, 1, 0},
                       {1, 1, 1},
                       {0, 1, 1} };
        System.out.println(FriendCircles.solution(M2));
        System.out.println(FriendCircles.solutionAlt(M2));
    }

}
