package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 24. Swap Nodes in Pairs<br>
 * https://leetcode.com/problems/swap-nodes-in-pairs<br><br>
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.<br>
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.<br>
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be 
 * changed.
 */
public class SwapNodesInPairs {
    
    public static ListNode solution(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev.next != null && prev.next.next != null) {
            ListNode node = prev.next.next;
            prev.next.next = node.next;
            node.next = prev.next;
            prev.next = node;
            prev = node.next;
        }
        
        return dummy.next;
    }
    
    public static ListNode solutionAlt(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode node = head.next;
        head.next = solutionAlt(head.next.next);
        node.next = head;
        return node;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(head);
        System.out.println(SwapNodesInPairs.solution(head));
        
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        System.out.println(head2);
        System.out.println(SwapNodesInPairs.solutionAlt(head2));
    }

}
