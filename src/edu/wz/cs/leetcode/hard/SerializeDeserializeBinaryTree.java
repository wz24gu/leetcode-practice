package edu.wz.cs.leetcode.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 297. Serialize and Deserialize Binary Tree<br>
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree<br><br>
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored 
 * in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or 
 * another computer environment.<br>
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization 
 * deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and 
 * this string can be deserialized to the original tree structure.<br>
 * 
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms 
 * should be stateless.
 */
public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
            return;
        }
        
        sb.append(node.val).append(",");
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(strs));
        return buildTree(queue);
    }
    
    private TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if ("#".equals(val)) {
            return null;
        }        
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
    
    public String serializeAlt(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
            else {
                sb.append("#").append(",");
            }
        }
        return sb.toString();
    }
    
    public TreeNode deserializeAlt(String data) {
        if (data.length() == 0) {
            return null;
        }
        
        String[] vals = data.split(",");        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.offer(root);
        
        int i = 1;
        while (i < vals.length) {
            TreeNode node = queue.poll();
            if (!"#".equals(vals[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                node.left = left;
                queue.offer(left);
            }
            i++;
            
            if (!"#".equals(vals[i])) {
                TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                node.right = right;
                queue.offer(right);
            }
            i++;
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        SerializeDeserializeBinaryTree serializeDeserializeBinaryTree = new SerializeDeserializeBinaryTree();
        System.out.println(serializeDeserializeBinaryTree.serialize(root));
        System.out.println(serializeDeserializeBinaryTree.deserialize(serializeDeserializeBinaryTree.serialize(root)));
        
        System.out.println(serializeDeserializeBinaryTree.serializeAlt(root));
        System.out.println(serializeDeserializeBinaryTree.deserializeAlt(serializeDeserializeBinaryTree.serializeAlt(root)));
    }
    
}
