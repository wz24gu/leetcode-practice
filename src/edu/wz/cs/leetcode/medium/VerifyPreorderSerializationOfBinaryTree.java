package edu.wz.cs.leetcode.medium;

import java.util.Stack;

/**
 * 331. Verify Preorder Serialization of a Binary Tree<br>
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree<br><br>
 * 
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the 
 * node's value. If it is a null node, we record using a sentinel value such as #.<br>
 * 
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a 
 * null node.<br>
 * 
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary 
 * tree. Find an algorithm without reconstructing the tree.<br>
 * 
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.<br>
 * 
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 */
public class VerifyPreorderSerializationOfBinaryTree {
    
    public static boolean solution(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }        
        
        Stack<String> stack = new Stack<>();
        String[] strs = preorder.split(",");
        for (String str : strs) {
            if (str.equals("#")) {
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
            stack.push(str);
        }
        
        return stack.size() == 1 && stack.peek().equals("#");
    }
    
    public static boolean solutionX(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        
        int diff = 1;
        String[] nodes = preorder.split(",");
        for (String node : nodes) {
            if (--diff < 0) {
                return false;
            }
            if (!node.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
    
    public static void main(String[] args) {
        System.out.println(VerifyPreorderSerializationOfBinaryTree.solution("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(VerifyPreorderSerializationOfBinaryTree.solution("1,#"));
        System.out.println(VerifyPreorderSerializationOfBinaryTree.solution("9,#,#,1"));
        
        System.out.println(VerifyPreorderSerializationOfBinaryTree.solutionX("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(VerifyPreorderSerializationOfBinaryTree.solutionX("1,#"));
        System.out.println(VerifyPreorderSerializationOfBinaryTree.solutionX("9,#,#,1"));
    }

}
