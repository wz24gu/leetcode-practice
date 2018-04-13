package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.ListNode;
import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 109. Convert Sorted List to Binary Search Tree<br>
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree<br><br>
 * 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.<br>
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1.
 */
public class ConvertSortedListToBinarySearchTree {

    public static TreeNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        
        while(fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow.next;
        prev.next = null;
        
        TreeNode node = new TreeNode(slow.val);
        if (head != slow) {
            node.left = solution(head);
        }
        node.right = solution(fast);
        
        return node;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        System.out.println(ConvertSortedListToBinarySearchTree.solution(head));
    }
    
}
