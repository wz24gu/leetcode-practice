package edu.wz.cs.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * 753. Cracking the Safe<br>
 * https://leetcode.com/problems/cracking-the-safe<br><br>
 * 
 * There is a box protected by a password. The password is n digits, where each letter can be one of the first k digits 
 * 0, 1, ..., k-1.<br>
 * 
 * You can keep inputting the password, the password will automatically be matched against the last n digits entered.<br>
 * 
 * For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.<br>
 * 
 * Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.<br><br>
 * 
 * Note:<br>
 * 1. n will be in the range [1, 4].<br>
 * 2. k will be in the range [1, 10].<br>
 * 3. k ^ n will be at most 4096.
 */
public class CrackingTheSafe {
    
    public static String solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int total = (int) Math.pow(k, n);
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        
        dfs(sb, total, visited, n, k);
        return sb.toString();
    }
    
    private static boolean dfs(StringBuilder sb, int goal, Set<String> visited, int n, int k) {
        if (visited.size() == goal) {
            return true;
        }
        String prev = sb.substring(sb.length() - n + 1, sb.length());
        for (int i = 0; i < k; i++) {
            String next = prev + i;
            if (!visited.contains(next)) {
                visited.add(next);
                sb.append(i);
                if (dfs(sb, goal, visited, n, k)) {
                    return true;
                }
                else {
                    visited.remove(next);
                    sb.delete(sb.length() - 1, sb.length());
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(CrackingTheSafe.solution(1, 2));
        System.out.println(CrackingTheSafe.solution(2, 2));
    }

}
