package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. Triangle<br>
 * https://leetcode.com/problems/triangle<br><br>
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the 
 * row below.<br>
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the 
 * triangle.
 */
public class Triangle {
    
    public static int solution(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(Arrays.asList(triangle.get(0).get(0)));
        
        for (int i = 1; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int val = triangle.get(i).get(j);
                if (j == 0) {
                    list.add(val + dp.get(i-1).get(j));
                }
                else if (j == triangle.get(i).size() - 1) {
                    list.add(val + dp.get(i-1).get(j-1));
                }
                else {
                    list.add(val + Math.min(dp.get(i-1).get(j-1), dp.get(i-1).get(j)));
                }
            }
            dp.add(list);
        }
        System.out.println(dp);
        
        int result = dp.get(n-1).get(0);
        for (int i : dp.get(n-1)) {
            result = Math.min(result, i);
        }
        return result;
    }
    
    public static int solutionX(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[triangle.get(n-1).size()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(n-1).get(i);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        
        return dp[0];
    }
    
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(Triangle.solution(triangle));
        System.out.println(Triangle.solutionX(triangle));
        
    }

}
