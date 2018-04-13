package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 143. Reorder List<br>
 * https://leetcode.com/problems/reorder-list<br><br>
 * 
 * Given a singly linked list L: L0 -> L1 -> ... -> Ln-1 -> Ln,<br>
 * reorder it to: L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 ...<br>
 * 
 * You must do this in-place without altering the nodes' values.
 */
public class ReorderList {
    
    public static void solution(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow.next;
        slow.next = null;
        mid = reverse(mid);
        
        while (head != null && mid != null) {
            ListNode next = head.next;
            head.next = mid;
            mid = mid.next;
            head.next.next = next;
            head = next;
        }        
    }
    
    private static ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ReorderList.solution(head);
        System.out.println(head);
    }

}
