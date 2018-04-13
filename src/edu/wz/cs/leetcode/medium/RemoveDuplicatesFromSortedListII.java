package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II<br>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii<br><br>
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the 
 * original list.<br>
 * 
 * For example,<br>
 * Given 1->2->3->3->4->4->5, return 1->2->5.<br>
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
    
    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev.next != null) {
            ListNode curr = prev.next;
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (curr != prev.next) {
                prev.next = curr.next;
            }
            else {
                prev = prev.next;
            }
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        System.out.println(RemoveDuplicatesFromSortedListII.solution(head));
        
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(3);
        System.out.println(RemoveDuplicatesFromSortedListII.solution(head2));
    }

}
