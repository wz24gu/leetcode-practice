package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 83. Remove Duplicates from Sorted List<br>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list<br><br>
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.<br>
 * 
 * For example,<br>
 * Given 1->1->2, return 1->2.<br>
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
    
    public static ListNode solution(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        System.out.println(head);
        System.out.println(RemoveDuplicatesFromSortedList.solution(head));
        
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);
        System.out.println(head2);
        System.out.println(RemoveDuplicatesFromSortedList.solution(head2));
    }

}
