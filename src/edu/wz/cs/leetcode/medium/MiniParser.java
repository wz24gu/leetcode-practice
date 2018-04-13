package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.NestedInteger;

/**
 * 385. Mini Parser<br>
 * https://leetcode.com/problems/mini-parser<br><br>
 * 
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.<br>
 * 
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.<br>
 * 
 * Note: You may assume that the string is well-formed:<br>
 * 1. String is non-empty.<br>
 * 2. String does not contain white spaces.<br>
 * 3. String contains only digits 0-9, [, - ,, ].
 */
public class MiniParser {
    
    public static NestedInteger solution(String s) {
        NestedInteger result = new NestedInteger();
        
        if (s == null || s.length() == 0) {
            return result;
        }
        
        if (s.charAt(0) != '[') {
            result.setInteger(Integer.parseInt(s));
            return result;
        }
        else if (s.length() <= 2) {
            return result;
        }
        
        
        int n = s.length();
        int start = 1;
        int count = 0;
        
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (count == 0 && (c == ',' || c == s.charAt(n-1))) {
                result.add(solution(s.substring(start, i)));
                start = i + 1;
            }
            else if (c == '[') {
                count++;
            }
            else if (c == ']') {
                count--;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(MiniParser.solution("[123,[456,[789]]]"));
    }

}
