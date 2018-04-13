package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 92. Reverse Linked List II<br>
 * https://leetcode.com/problems/reverse-linked-list-ii<br><br>
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.<br>
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,<br>
 * return 1->4->3->2->5->NULL.<br>
 * 
 * Note:<br>
 * 1. Given m, n satisfy the following condition: 1 <= m <= n <= length of list.
 */
public class ReverseLinkedListII {

    public static ListNode solution(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode curr = dummy;
        ListNode prev = null;
        ListNode first = null;
        ListNode last = null;
        
        for (int i = 1; i < m; i++) {
            curr = curr.next;
        }
        prev = curr;
        last = curr.next;
        
        for (int i = m; i <= n; i++) {
            curr = prev.next;
            prev.next = curr.next;
            curr.next = first;
            first = curr;
        }
        
        curr = prev.next;
        prev.next = first;
        last.next = curr;
        return dummy.next;   
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(ReverseLinkedListII.solution(head, 2, 4));
    }

}
