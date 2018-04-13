package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 449. Serialize and Deserialize BST<br>
 * https://leetcode.com/problems/serialize-and-deserialize-bst<br><br>
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be 
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the 
 * same or another computer environment.<br>
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your 
 * serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be 
 * serialized to a string and this string can be deserialized to the original tree structure.<br>
 * 
 * The encoded string should be as compact as possible.<br>
 * 
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms 
 * should be stateless.
 */
public class SerializeDeserializeBinarySearchTree {
    
    private static final String SEPARATOR = ",";
    private static final String NULL = "null";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL + SEPARATOR);
            return;
        }
        sb.append(node.val + SEPARATOR);
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(SEPARATOR)));
        return buildTree(queue);
    }
    
    private TreeNode buildTree(Queue<String> queue) {
        String current = queue.poll();
        if (NULL.equals(current)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(current));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        SerializeDeserializeBinarySearchTree coder = new SerializeDeserializeBinarySearchTree();
        System.out.println(coder.serialize(root));
    }

}
