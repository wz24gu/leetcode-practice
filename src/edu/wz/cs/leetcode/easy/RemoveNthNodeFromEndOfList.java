package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 19. Remove Nth Node From End of List<br/>
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list<br/><br/>
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.<br/><br/>
 * 
 * Note:<br/>
 * 1. Given n will always be valid.<br/>
 * 2. Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList {
    
    public static ListNode solution(ListNode head, int n) {
        ListNode curr = head;
        ListNode prev = head;
        
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        if (curr == null) {
            return head.next;
        }
        
        while (curr.next != null) {
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        System.out.println(head);
        System.out.println(RemoveNthNodeFromEndOfList.solution(head, 2));
    }

}
