package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 536. Construct Binary Tree from String<br>
 * https://leetcode.com/problems/construct-binary-tree-from-string<br><br>
 * 
 * You need to construct a binary tree from a string consisting of parenthesis and integers.<br>
 * 
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. 
 * The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same 
 * structure.<br>
 * 
 * You always start to construct the left child node of the parent first if it exists.<br><br>
 * 
 * Note:<br>
 * 1. There will only be '(', ')', '-' and '0' ~ '9' in the input string.<br>
 * 2. An empty tree is represented by "" instead of "()".
 */
public class ConstructBinaryTreeFromString {
    
    public static TreeNode solution(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        
        int first = s.indexOf('(');
        if (first == -1) {
            int val = Integer.parseInt(s);
            TreeNode node = new TreeNode(val);
            return node;
        }
        else {
            int val = Integer.parseInt(s.substring(0, first));
            TreeNode node = new TreeNode(val);
            
            int n = s.length();
            int count = 0;
            int start = first;
            for (int i = start; i < n; i++) {
                if (s.charAt(i) == '(') {
                    count++;
                }
                else if (s.charAt(i) == ')'){
                    count--;
                }
                
                if (count == 0 && start == first) {
                    node.left = solution(s.substring(start + 1, i));
                    start = i + 1;
                }
                else if (count == 0) {
                    node.right = solution(s.substring(start + 1, i));
                }
            }
            
            return node;
        }        
    }
    
    public static TreeNode solutionAlt(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        
        int n = s.length();
        int i = 0;
        TreeNode root = null;
        
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) != '(') {
                j++;
            }            
            int val = Integer.parseInt(s.substring(i, j));
            root = new TreeNode(val);
            
            i = j;
            int count = 0;
            int start = i;
            for (j = start; j < n; j++) {
                if (s.charAt(j) == '(') {
                    count++;
                }
                else if (s.charAt(j) == ')') {
                    count--;
                }
                
                if (count == 0) {
                    if (start == i) {
                        root.left = solutionAlt(s.substring(start + 1, j));
                        count = 0;
                        start = j + 1;
                    }
                    else {
                        root.right = solutionAlt(s.substring(start + 1, j));
                    }
                }
            }
            i = j;
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        System.out.println(ConstructBinaryTreeFromString.solution("4(2(3)(1))(6(5))"));
        System.out.println(ConstructBinaryTreeFromString.solutionAlt("4(2(3)(1))(6(5))"));
    }

}
