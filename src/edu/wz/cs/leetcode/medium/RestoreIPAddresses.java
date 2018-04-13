package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses<br>
 * https://leetcode.com/problems/restore-ip-addresses<br><br>
 * 
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 */
public class RestoreIPAddresses {
    
    public static List<String> solution(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        
        helper(s, 0, "", res);
        return res;
    }
    
    private static void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.length() == 0) {
                res.add(out);
            }
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            if (s.length() < i) {
                break;
            }
            String sub = s.substring(0, i);            
            if (sub.startsWith("0") && sub.length() != 1 || Integer.parseInt(sub) > 255) {
                continue;
            }
            helper(s.substring(i), n + 1, out + sub + (n == 3 ? "" : "."), res);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(RestoreIPAddresses.solution("25525511135"));
    }

}
