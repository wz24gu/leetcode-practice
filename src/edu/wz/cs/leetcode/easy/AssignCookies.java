package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 455. Assign Cookies<br>
 * https://leetcode.com/problems/assign-cookies<br><br>
 * 
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most
 * one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content
 * with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will
 * be content. Your goal is to maximize the number of your content children and output the maximum number.<br><br>
 * 
 * Note:<br>
 * 1. You may assume the greed factor is always positive.<br>
 * 2. You cannot assign more than one cookie to one child.
 */
public class AssignCookies {
    
    public static int solution(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) {
            return 0;
        }
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int result = 0;
        int i = g.length - 1;
        int j = s.length - 1;        
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                result++;
                j--;
                i--;
            }
            else {
                i--;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(AssignCookies.solution(g, s));
        
        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.println(AssignCookies.solution(g2, s2));
    }

}
