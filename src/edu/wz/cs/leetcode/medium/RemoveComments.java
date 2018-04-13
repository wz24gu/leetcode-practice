package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 722. Remove Comments<br>
 * https://leetcode.com/problems/remove-comments<br><br>
 * 
 * Note:<br>
 * 1. The length of source is in the range [1, 100].<br>
 * 2. The length of source[i] is in the range [0, 80].<br>
 * 3. Every open block comment is eventually closed.<br>
 * 4. There are no single-quote, double-quote, or control characters in the source code.
 */
public class RemoveComments {
    
    public static List<String> solution(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isBlock = false;
        
        for (String s : source) {
            int n = s.length();
            for (int i = 0; i < n; i++) {
                if (isBlock) {
                    if (s.charAt(i) == '*' && i < n - 1 && s.charAt(i+1) == '/') {
                        isBlock = false;
                        i++;
                    }
                }
                else {
                    if (s.charAt(i) == '/' && i < n - 1 && s.charAt(i+1) == '/') {
                        break;
                    }
                    else if (s.charAt(i) == '/' && i < n - 1 && s.charAt(i+1) == '*') {
                        isBlock = true;
                        i++;
                    }
                    else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            
            if (!isBlock && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        System.out.println(RemoveComments.solution(source));
        
        String[] source2 = {"a/*comment", "line", "more_comment*/b"};
        System.out.println(RemoveComments.solution(source2));
    }

}
