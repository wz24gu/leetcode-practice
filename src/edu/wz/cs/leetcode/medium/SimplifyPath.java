package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 71. Simplify Path<br>
 * https://leetcode.com/problems/simplify-path<br><br>
 * 
 * Given an absolute path for a file (Unix-style), simplify it.<br>
 * 
 * For example,<br>
 * path = "/home/", => "/home"<br>
 * path = "/a/./b/../../c/", => "/c"<br>
 * 
 * Corner Cases:<br>
 * Did you consider the case where path = "/../"?<br>
 * In this case, you should return "/".<br>
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".<br>
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {
    
    public static String solution(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        
        Stack<String> stack = new Stack<>();
        String[] pa = path.split("/");
        for (String s : pa) {
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            }
            else if (!s.equals(".") && !s.equals("..") && !s.equals("")) {
                stack.push(s);
            }
        }
        
        List<String> list = new ArrayList<>(stack);
        return "/" + String.join("/", list);   
    }
    
    public static void main(String[] args) {
        System.out.println(SimplifyPath.solution("/home/"));
        System.out.println(SimplifyPath.solution("/a/./b/../../c/"));
        System.out.println(SimplifyPath.solution("/../"));
        System.out.println(SimplifyPath.solution("/home//foo/"));
    }

}
